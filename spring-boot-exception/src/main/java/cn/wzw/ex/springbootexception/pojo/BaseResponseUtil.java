package cn.wzw.ex.springbootexception.pojo;

/**
 * @Author Wangzhiwen
 * @ClassName BaseResponseUtil
 * @Description
 * @Date 2019/6/27 14:50
 * @Version 1.0
 */
public final class BaseResponseUtil {
    /*统一设置返回内容*/
    public static BaseResopnse result(Integer code,String msg,Object data,PageEntity pageEntity){
        return new BaseResopnse(code,msg,data,pageEntity);
    }

    /*成功，无数据返回*/
    public static BaseResopnse success(){
        return BaseResponseUtil.result(BaseResponseCode.SUCCESS.getCode(),BaseResponseCode.SUCCESS.getMsg(),null,null);
    }

    /*成功，无分页数据*/
    public static BaseResopnse success(Object data){
        Integer code = BaseResponseCode.SUCCESS.getCode();
        String msg = BaseResponseCode.SUCCESS.getMsg();
        return BaseResponseUtil.result(code,msg,data,null);
    }

    /*成功，有全部数据*/
    public static BaseResopnse success(Object data,PageEntity pageEntity){
        return BaseResponseUtil.result(BaseResponseCode.SUCCESS.getCode(),BaseResponseCode.SUCCESS.getMsg(),data,pageEntity);
    }

    /*错误*/
    public static BaseResopnse error(BaseResponseCode responseCode){
        return BaseResponseUtil.result(responseCode.getCode(),responseCode.getMsg(),null,null);
    }

    /*错误，自定义*/
    public static BaseResopnse error(Integer code,String msg){
        return BaseResponseUtil.result(code,msg,null,null);
    }
}
