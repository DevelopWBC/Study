package springbootcase.demo.config.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springbootcase.demo.web.interceptor.MyInterceptor;



/**
 * @Author Wangzhiwen
 * @ClassName ChildConfig
 * @Description
 * @Date 2019/7/30 16:43
 * @Version 1.0
 */
// springboot中不需要。启动类会扫描所有
/*@ComponentScan(value = "springbootcase",
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class, RestController.class})},
        useDefaultFilters = false)*/
@EnableWebMvc // springboot启动时会自动装配bean初始化好组件，使用此注解可以全面接管。高度定制
@Configuration
public class ChildConfig implements WebMvcConfigurer {
    /**
     * 实现WebMvcConfigurer中的方法即可
     */
    // 注册mvc拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

}
