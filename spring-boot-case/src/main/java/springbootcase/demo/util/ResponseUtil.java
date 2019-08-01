package springbootcase.demo.util;

import springbootcase.demo.pojo.vo.BaseResponseCode;
import springbootcase.demo.pojo.vo.PageRes;
import springbootcase.demo.pojo.vo.ResponseResult;

/**
 * @Author Wangzhiwen
 * @ClassName ResponseUtil
 * @Description
 * @Date 2019/7/1 13:43
 * @Version 1.0
 */
public class ResponseUtil {
    /*统一设置返回内容*/
    public static<T> ResponseResult result(Integer code, String msg, Object data, PageRes<T> pageRes){
        return new ResponseResult<>(code, msg, data, pageRes);
    }


    /*成功，无数据返回*/
    public static ResponseResult success(){
        return ResponseUtil.result(BaseResponseCode.SUCCESS.getCode(),BaseResponseCode.SUCCESS.getMsg(),null,null);
    }

    /*成功，无分页数据*/
    public static ResponseResult success(Object data){
        Integer code = BaseResponseCode.SUCCESS.getCode();
        String msg = BaseResponseCode.SUCCESS.getMsg();
        return ResponseUtil.result(code,msg,data,null);
    }

    /*成功，无数据*/
    public static<T> ResponseResult success(PageRes<T> pageRes){
        Integer code = BaseResponseCode.SUCCESS.getCode();
        String msg = BaseResponseCode.SUCCESS.getMsg();
        return ResponseUtil.result(code,msg,null,pageRes);
    }

    /*成功，有全部数据*/
    public static<T> ResponseResult success(Object data,PageRes<T> pageRes){
        return ResponseUtil.result(BaseResponseCode.SUCCESS.getCode(),BaseResponseCode.SUCCESS.getMsg(),data,pageRes);
    }

    /*错误*/
    public static ResponseResult error(BaseResponseCode responseCode){
        return ResponseUtil.result(responseCode.getCode(),responseCode.getMsg(),null,null);
    }

    /*错误，自定义*/
    public static ResponseResult error(Integer code,String msg){
        return ResponseUtil.result(code,msg,null,null);
    }
}
