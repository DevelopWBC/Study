package springbootcase.demo.exception;

import springbootcase.demo.pojo.vo.BaseResponseCode;

/**
 * @Author Wangzhiwen
 * @ClassName BaseException
 * @Description
 * @Date 2019/7/1 13:15
 * @Version 1.0
 */
public class BaseException extends RuntimeException {
    private Integer code;

    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    private BaseException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public BaseException(BaseResponseCode baseResponseCode) {
        this(baseResponseCode.getCode(),baseResponseCode.getMsg());
    }

    public Integer getCode() {
        return code;
    }


    public void setCode(Integer code) {
        this.code = code;
    }
}
