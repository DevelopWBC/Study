package springbootcase.demo.config.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author Wangzhiwen
 * @ClassName AOPConfig
 * @Description：注解方式使用spring封装的AOP操作
 * @Date 2019/5/27 10:59
 * @Version 1.0
 */
@Configuration
@EnableAspectJAutoProxy //开启注解方式的AOP
public class AOPConfig {
    @Bean
    public Target target(){
        return new Target();
    }

    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
