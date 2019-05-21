package cn.wzw.ex.springbootexception.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Author Wangzhiwen
 * @ClassName GlobalException
 * @Description：第四种处理异常的方式，配置simpleMappingExceptionReosolcer
 * @Date 2019/5/6 13:46
 * @Version 1.0
 */
@Configuration
public class GlobalException {
    /**
      *@author Wangzhiwen
      *@description：返回值类型必须为SimpleMappingExceptionResolver
      *@date 2019/5/6 13:48
      *@param []
      *@return org.springframework.web.servlet.handler.SimpleMappingExceptionResolver
    */
    @Bean
    public SimpleMappingExceptionResolver getEx(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        //设置异常信息的映射，返回到具体页面
        Properties properties = new Properties();
        //参数：异常的类型，写全路径名；视图名称
        properties.put("java.lang.NullPointerException","error");
        properties.put("java.lang.ArithmeticException","error2");
        //可以一个方法针对于不同的异常类型，跳转到不同的页面。
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
