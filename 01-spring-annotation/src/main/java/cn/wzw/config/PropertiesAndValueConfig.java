package cn.wzw.config;

import cn.wzw.pojo.PropertiesAndValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author Wangzhiwen
 * @ClassName PropertiesAndValueConfig
 * @Description：注解@PropertySource和@value的使用
 * @Date 2019/5/24 17:09
 * @Version 1.0
 */
@PropertySource(value = "classpath:/value.properties")
@Configuration
public class PropertiesAndValueConfig {
    @Bean
    public PropertiesAndValue propertiesAndValue(){return new PropertiesAndValue();}

}
