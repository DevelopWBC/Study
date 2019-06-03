package cn.wzw.springBootKnowledgEextension.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Wangzhiwen
 * @ClassName DruidDataSource
 * @Description
 * @Date 2019/6/3 9:54
 * @Version 1.0
 */
@Configuration
public class DruidDataSource {
    //1.配置Druid数据源，将配置文件中的spring.datasource属性映射到数据源中。
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource dataSource(){
        com.alibaba.druid.pool.DruidDataSource source = new com.alibaba.druid.pool.DruidDataSource();
        return source;
    }

    //2.配置Druid监控的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/durid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("password","admin");
        initParams.put("allow","");
        initParams.put("deny","192.167.1.170");
        statViewServletServletRegistrationBean.setInitParameters(initParams);
        return statViewServletServletRegistrationBean;
    }

    //3.配置Druid监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");
        webStatFilterFilterRegistrationBean.setInitParameters(initParams);
        webStatFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return webStatFilterFilterRegistrationBean;
    }
}
