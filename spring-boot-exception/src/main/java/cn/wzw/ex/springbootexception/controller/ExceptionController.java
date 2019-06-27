package cn.wzw.ex.springbootexception.controller;

import cn.wzw.ex.springbootexception.exception.ParamsException;
import cn.wzw.ex.springbootexception.pojo.BaseResponseCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Wangzhiwen
 * @ClassName Exception
 * @Description：springboot处理异常的五种方式
 * @Date 2019/5/6 11:42
 * @Version 1.0
 */
@Controller
public class ExceptionController {

    /**
      *@author Wangzhiwen
      *@description:第一中处理异常的方式：发生异常时会自动跳转到error页面。可以自定义一个，在templates文件夹下
      *@date 2019/5/6 13:00
      *@param []
      *@return java.lang.String
    */
    @RequestMapping(value = "/exception1")
    public String first(){
        //int a = 100/0;
        String s = null;
        try {
            s.length();//空指针异常
            return null;
        }catch (NullPointerException e){
            throw new ParamsException(BaseResponseCode.PARAMS_ERROR);
        }
    }

    /**
      *@author Wangzhiwen
      *@description:第二种方式：使用@exceptionHandle注解，规定发生某一类异常时需要处理的流程。
     *  优点：可以细化某一类异常
     *  缺点：必须和可能发生异常的方法写在同一个类中。
      *@date 2019/5/6 13:26
      *@param
      *@return
     */
/*    @ExceptionHandler(value = {java.lang.ArithmeticException.class})
    public void second(){
        System.out.println("使用@ExceptionHandler处理异常......热部署。。。再次部署");
    }*/


}
