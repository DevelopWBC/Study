package cn.wzw.ex.springbootexception.exception;

import cn.wzw.ex.springbootexception.pojo.BaseResponseCode;

/**
 * @Author Wangzhiwen
 * @ClassName BaseException
 * @Description
 * @Date 2019/6/27 13:43
 * @Version 1.0
 */
public class BaseException extends RuntimeException {

    private Integer code;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    private BaseException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public BaseException(BaseResponseCode responseCode) {
        this(responseCode.getCode(),responseCode.getMsg());
    }

    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }
}
