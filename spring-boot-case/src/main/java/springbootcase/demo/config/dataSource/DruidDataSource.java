package springbootcase.demo.config.dataSource;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.Collections;
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
    @ConfigurationProperties(prefix = "datasource.test1")
    @Bean(name = "test1DataSource")
    @Qualifier("test1DataSource")
    public DataSource dataSource(){
        com.alibaba.druid.pool.DruidDataSource source = new com.alibaba.druid.pool.DruidDataSource();
        return source;
    }

    @ConfigurationProperties(prefix = "datasource.test2")
    @Primary
    @Bean(name = "test2DataSource")
    @Qualifier("test2DataSource")
    public DataSource test2DataSource(){
        com.alibaba.druid.pool.DruidDataSource source = new com.alibaba.druid.pool.DruidDataSource();
        return source;
    }

    @ConfigurationProperties(prefix = "datasource.test3")
    @Bean(name = "test3DataSource")
    @Qualifier("test3DataSource")
    public DataSource test3DataSource(){
        com.alibaba.druid.pool.DruidDataSource source = new com.alibaba.druid.pool.DruidDataSource();
        return source;
    }

    //2.配置Druid监控的servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean =
                /**
                 * 严重警告：不要在写错单词了
                 */
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String,String> initParams = new HashMap<>();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        initParams.put("allow","127.0.0.1");
        initParams.put("deny","");
        statViewServletServletRegistrationBean.setInitParameters(initParams);
        return statViewServletServletRegistrationBean;
    }

    //3.配置Druid监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<WebStatFilter> webStatFilterFilterRegistrationBean = new FilterRegistrationBean<>(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,*.gif,*.jpg,*.png,/druid/*");
        webStatFilterFilterRegistrationBean.setInitParameters(initParams);
        webStatFilterFilterRegistrationBean.setUrlPatterns(Collections.singletonList("/*"));
        return webStatFilterFilterRegistrationBean;
    }
}
