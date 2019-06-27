package cn.wzw.ex.springbootexception.exception;

import cn.wzw.ex.springbootexception.pojo.BaseResponseCode;

/**
 * @Author Wangzhiwen
 * @ClassName ParamsException
 * @Description
 * @Date 2019/6/27 13:43
 * @Version 1.0
 */
public class ParamsException extends BaseException {

    public ParamsException(BaseResponseCode responseCode) {
        super(responseCode);
    }
}
