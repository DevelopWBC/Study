package cn.wzw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author Wangzhiwen
 * @ClassName MVCConfig
 * @Description
 * @Date 2019/5/28 16:32
 * @Version 1.0
 */
@Configuration
@ComponentScan(value = "cn.wzw",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)},useDefaultFilters = false)
@EnableWebMvc //开启mvc配置注解，继承
public class MVCConfig implements WebMvcConfigurer {

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

    //视图映射
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/jsps/",".jsp");
    }

}
