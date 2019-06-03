package cn.wzw.springBootKnowledgEextension.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Wangzhiwen
 * @ClassName MyBatisConfig
 * @Description：不使用xml配置文件是可以编写配置类完成扩展配置
 * @Date 2019/6/3 13:19
 * @Version 1.0
 */
@Configuration
public class MyBatisConfig {
    //实现接口ConfigurationCustomizer，完成mapper定制功能
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰命名
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
