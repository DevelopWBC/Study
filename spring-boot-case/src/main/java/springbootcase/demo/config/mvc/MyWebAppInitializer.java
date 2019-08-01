package springbootcase.demo.config.mvc;

/**
 * @Author Wangzhiwen
 * @ClassName MyWebAppInitializer
 * @Description：
 *  web容器启动的时候创建对象，继承抽象类，创建父容器和子容器对象。springbooot中不需要
 * @Date 2019/7/30 16:40
 * @Version 1.0
 */
public class MyWebAppInitializer {
    //extends AbstractAnnotationConfigDispatcherServletInitializer {

/*    // 父容器，获取父容器的配置类。spring配置文件
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    // 子容器，获取子容器的配置类。mvc配置文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{ChildConfig.class};
    }

    //  获取DispatcherServlet的映射信息
    //  /：拦截所有请求（包括静态资源（xx.js,xx.png）），但是不包括*.jsp；
    //  /*：拦截所有请求；连*.jsp页面都拦截；jsp页面是tomcat的jsp引擎解析的；
    //拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }*/
}
