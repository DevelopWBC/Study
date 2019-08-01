package springbootcase.demo.util;

import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by MengJunlong on 2018/8/14.
 *
 * @Description gson工具类
 */
public class GSON {
    private static Gson gson = new GsonBuilder().setExclusionStrategies(new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            String name=f.getName();
            return name.equals("isDeleted");
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    })
            .registerTypeAdapter(Map.class,new ObjectTypeAdapter())//防止反序列化Map时将long解析成double
            .registerTypeAdapter(new TypeToken<Map<String,Object>>(){}.getType(),new ObjectTypeAdapter())
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")//设置时间格式化
            .serializeNulls()
            .create();
    private static JsonParser jsonParser = new JsonParser();

    public static Gson getGson() {
        return gson;
    }

    public static JsonParser getJsonParser() {
        return jsonParser;
    }

    public static String toJson(Object o) {
        return gson.toJson(o);
    }
    public static JsonObject toJsonObject(Object o){
        String jsonStr=toJson(o);
        return jsonParser.parse(jsonStr).getAsJsonObject();
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T fromJson(JsonElement json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static Date stringToDate(String str){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 修改部分源码，防止数值类型全部解析成double
     * @Author MengJunlong
     * @Date 2018/9/12
     */
    public static class ObjectTypeAdapter extends TypeAdapter<Object>{

        /**
         * Writes one JSON value (an array, object, string, number, boolean or null)
         * for {@code value}.
         *
         * @param out
         * @param value the Java object to write. May be null.
         */
        @Override
        public void write(JsonWriter out, Object value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }

            TypeAdapter<Object> typeAdapter = (TypeAdapter<Object>) gson.getAdapter(value.getClass());
            if (typeAdapter instanceof ObjectTypeAdapter) {
                out.beginObject();
                out.endObject();
                return;
            }

            typeAdapter.write(out, value);
        }

        /**
         * Reads one JSON value (an array, object, string, number, boolean or null)
         * and converts it to a Java object. Returns the converted object.
         *
         * @param in
         * @return the converted Java object. May be null.
         */
        @Override
        public Object read(JsonReader in) throws IOException {
            JsonToken token = in.peek();
            switch (token) {
                case BEGIN_ARRAY:
                    List<Object> list = new ArrayList<Object>();
                    in.beginArray();
                    while (in.hasNext()) {
                        list.add(read(in));
                    }
                    in.endArray();
                    return list;

                case BEGIN_OBJECT:
                    Map<String, Object> map = new LinkedTreeMap<String, Object>();
                    in.beginObject();
                    while (in.hasNext()) {
                        map.put(in.nextName(), read(in));
                    }
                    in.endObject();
                    return map;

                case STRING:
                    return in.nextString();

                case NUMBER:
                    double dbNum = in.nextDouble();

                    // 数字超过long的最大值，返回浮点类型
                    if (dbNum > Long.MAX_VALUE) {
                        return dbNum;
                    }

                    // 判断数字是否为整数值
                    long lngNum = (long) dbNum;
                    if (dbNum == lngNum) {
                        if (lngNum<=Integer.MAX_VALUE){
                            return (int)lngNum;
                        }
                        return lngNum;
                    } else {
                        return dbNum;
                    }

                case BOOLEAN:
                    return in.nextBoolean();

                case NULL:
                    in.nextNull();
                    return null;

                default:
                    throw new IllegalStateException();
            }
        }
    }
}
