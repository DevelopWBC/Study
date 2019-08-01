package springbootcase.demo.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Wangzhiwen
 * @ClassName MyInterceptor
 * @Description
 * @Date 2019/7/30 16:53
 * @Version 1.0
 */

// mvc拦截器，和之间逻辑一样实现HandlerInterceptor接口。使用注解方式实现springmvc后，需要在mvc配置类中手动注册进去。拦不住servlet请求
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
