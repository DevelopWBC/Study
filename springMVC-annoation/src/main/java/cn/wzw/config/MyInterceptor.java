package cn.wzw.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Wangzhiwen
 * @ClassName MyInterceptor
 * @Description
 * @Date 2019/5/28 17:01
 * @Version 1.0
 */
public class MyInterceptor implements HandlerInterceptor {
    //进入方法前执行，返回true代表放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //业务逻辑处理，和filter功能相同。spring
        System.out.println("拦截器拦截检查。。。。");
        return true;
    }

    //方法执行完成后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("目标方法执行完成了。。。。");
    }

    //页面响应后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("页面响应完成了。。");
    }
}
