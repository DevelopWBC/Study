package cn.wzw.ex.springbootexception.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Wangzhiwen
 * @ClassName FException
 * @Description：实现HandlerExceptionResolver接口，全局异常处理器
 * @Date 2019/5/6 13:56
 * @Version 1.0
 */
@Configuration
public class FException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView view = new ModelAndView();
        //根据异常类型做不同的处理方式
        if (e instanceof NullPointerException)
            System.out.println("空指针异常");
        if (e instanceof ClassCastException)
            System.out.println("类型转换异常。");
        if (e instanceof IndexOutOfBoundsException)
            System.out.println("数组下标越界");
        view.addObject("error","错误信息");
        view.setViewName("error");
        return view;
    }
}
