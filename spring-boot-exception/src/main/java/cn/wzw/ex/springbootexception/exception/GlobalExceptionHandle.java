package cn.wzw.ex.springbootexception.exception;

import cn.wzw.ex.springbootexception.pojo.BaseResopnse;
import cn.wzw.ex.springbootexception.pojo.BaseResponseCode;
import cn.wzw.ex.springbootexception.pojo.BaseResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

/**
 * @Author Wangzhiwen
 * @ClassName GlobalExceptionHandle
 * @Description
 * @Date 2019/6/27 15:12
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandle {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);
    /*捕获未知异常*/
/*    @ExceptionHandler(value = Exception.class)
    public BaseResopnse exceptionHandler(Exception e){
        logger.error(e.getMessage(),e);
        return BaseResponseUtil.error(BaseResponseCode.ERROR);
    }*/

    /*捕获业务异常*/
    @ExceptionHandler(value = BaseException.class)
    public BaseResopnse baseExceptionHandler(BaseException e){
        logger.error(e.getMessage(),e);
        return BaseResponseUtil.error(e.getCode(),e.getMessage());
    }

    /*网络连接异常*/
    @ExceptionHandler(value = RestClientException.class)
    public BaseResopnse restClientExceptionHandler(RestClientException e){
        logger.error("网络连接异常",e);
        return BaseResponseUtil.error(BaseResponseCode.ERROR);
    }
}
