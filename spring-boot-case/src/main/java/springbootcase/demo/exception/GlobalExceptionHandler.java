package springbootcase.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import springbootcase.demo.pojo.vo.BaseResponseCode;
import springbootcase.demo.pojo.vo.ResponseResult;
import springbootcase.demo.util.ResponseUtil;

/**
 * @Author Wangzhiwen
 * @ClassName GlobalExceptionHandler
 * @Description：全局异常处理器
 * @Date 2019/7/1 13:46
 * @Version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /*捕获业务异常*/
    @ExceptionHandler(value = BaseException.class)
    public ResponseResult baseExceptionHandler(BaseException e){
        logger.error(e.getMessage(),e);
        return ResponseUtil.error(e.getCode(),e.getMessage());
    }

    /*网络连接异常*/
    @ExceptionHandler(value = RestClientException.class)
    public ResponseResult restClientExceptionHandler(RestClientException e){
        logger.error("网络连接异常",e);
        return ResponseUtil.error(BaseResponseCode.ERROR);
    }

    /*捕获未知异常*/
    @ExceptionHandler(value = Exception.class)
    public ResponseResult exceptionHandler(Exception e){
        logger.error(e.getMessage(),e);
        return ResponseUtil.error(BaseResponseCode.ERROR);
    }
}
