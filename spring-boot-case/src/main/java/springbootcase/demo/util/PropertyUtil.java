package springbootcase.demo.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by MengJunlong on 2018/9/18.
 *
 * @Description
 */
public class PropertyUtil {
    /**
     * 默认值
     */
    public static final String basePrice= "200";
    public static final String maxPrice= "1200";
    public static final String deposit= "100";
    public static final String quota= "3";
    public static final String startBeforeDeparture= "8";
    public static final String endBeforeDeparture= "2";
    public static final String runningDays= "1";
    public static final String cabinClass= "Y,B,M,U,H,Q,V,W,S,T,Z,E,K,G,L";
    public static final String cabinClassEnable= "Y";

    //旧数据中航班组别
    public static final String defaultFlightGroup= "qt";


    /**
     * 设置属性值
     *
     * @param key
     * @param value
     * @return void
     * @Author MengJunlong
     * @Date 2018/9/18
     */
    public static void setProperty(String key, String value) {
        setProperty(key, value,"default.properties");
    }

    /**
     * 获取属性值，不存在时返回null
     *
     * @param key
     * @return java.lang.String
     * @Author MengJunlong
     * @Date 2018/9/18
     */
    public static String getProperty(String key, String defaultValue) {
        return getProperty(key, defaultValue,"default.properties");
    }

    /**
     * 设置属性值
     *
     * @param key
     * @param value
     * @return void
     * @Author MengJunlong
     * @Date 2018/9/18
     */
    public static void setProperty(String key, String value,String fileName) {
        if (key == null || key.length() <= 0 || value == null || value.length() <= 0) {
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        File file=getPropertyFile(fileName);
        try {
            in = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(new InputStreamReader(in,"utf-8"));
            out = new FileOutputStream(file);
            properties.setProperty(key, value);
            properties.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取属性值，不存在时返回null
     *
     * @param key
     * @return java.lang.String
     * @Author MengJunlong
     * @Date 2018/9/18
     */
    public static String getProperty(String key, String defaultValue,String fileName) {
        if (key == null || key.length() <= 0) {
            return null;
        }
        String res = null;
        InputStream in = null;
        OutputStream out = null;
        File file=getPropertyFile(fileName);
        try {
            in = new FileInputStream(file);
            Properties properties = new Properties();
            BufferedReader bf = new BufferedReader(new InputStreamReader(in,"utf-8"));
//            properties.load(new InputStreamReader(in,"gbk"));
            properties.load(bf);
            res = properties.getProperty(key);
            if (res == null) {//如果不存在则将默认值写入
                out=new FileOutputStream(file);
                res = defaultValue;
                properties.setProperty(key, res);
                properties.store(out,null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out!=null){
                    out.close();
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 获取存储属性的文件对象
     *
     * @param
     * @return java.io.File
     * @Author MengJunlong
     * @Date 2018/9/18
     */
    public static File getPropertyFile(String fileName) {
        String dir = System.getProperty("user.dir");
        File file = new File(dir + "/config/"+fileName);
        if (!file.exists()) {
            OutputStream outputStream=null;
            InputStream inputStream=null;
            try {
                File d=new File(file.getParent());
                /**
                 * 当目录不存在时，创建目录
                 * 当已存在同名文件时，删除文件，创建目录
                 */
                if (!d.exists()||!d.isDirectory()){
                    d.delete();
                    d.mkdir();
                }
                //创建配置文件
                file.createNewFile();
                //复制默认配置文件
                outputStream=new FileOutputStream(file);
                inputStream=PropertyUtil.class.getResourceAsStream("/"+fileName);
                int b=0;
                while ((b=inputStream.read())!=-1){
                    outputStream.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    outputStream.flush();
                    outputStream.close();
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }
}
