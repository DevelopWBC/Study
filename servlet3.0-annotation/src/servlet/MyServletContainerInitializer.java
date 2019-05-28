package servlet;

import handlesTypes.ExServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;

/**
 * @Author Wangzhiwen
 * @ClassName MyServletContainerInitializer
 * @Description：容器启动的时候会将@HandlesTypes指定的这个类型下面的子类（实现类，子接口等）传递过来；传入感兴趣的类型；
 * @Date 2019/5/28 14:45
 * @Version 1.0
 */
@HandlesTypes(value = ExServlet.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
    /**
     * 应用启动的时候，会运行onStartup方法；
     *
     * Set<Class<?>> set：感兴趣的类型的所有子类型；
     * ServletContext servletContext:代表当前Web应用的ServletContext；一个Web应用一个ServletContext；
     *
     * 1）、使用ServletContext注册Web组件（Servlet、Filter、Listener）
     * 2）、使用编码的方式，在项目启动的时候给ServletContext里面添加组件；
     * 		必须在项目启动的时候来添加；
     * 		1）、ServletContainerInitializer得到的ServletContext；
     * 		2）、ServletContextListener得到的ServletContext；
     */
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        //遍历感兴趣的类型
        for (Class<?> aClass : set) {
            System.out.println(aClass.getClass());
        }

        //注册servlet
        ServletRegistration.Dynamic b = servletContext.addServlet("b", BServlet.class);
        //设置映射地址
        b.addMapping("/bservlet");
        //注册litenter
        servletContext.addListener(CListenter.class);
        //注册filter
        FilterRegistration.Dynamic d = servletContext.addFilter("d", DFilter.class);
        //设置拦截方式
        DispatcherType request = DispatcherType.REQUEST;
        //拦截路径
        String path = "/**";
        d.addMappingForUrlPatterns(EnumSet.of(request),true,path);
    }
}
