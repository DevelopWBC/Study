package cn.wzw.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Author Wangzhiwen
 * @ClassName ProfileConfig
 * @Description：spring通过@Peofile注解对多环境配置切断的支持
 * @Date 2019/5/29 11:02
 * @Version 1.0
 */
@PropertySource("classpath:/db.properties")
@Configuration
public class ProfileConfig {
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.classname}")
    private String classname;
    @Value("${jdbc.username}")
    private String username;
    @Value("jdbc.password")
    private String password;

    //测试环境
    @Profile("test")
    @Bean(name = "testDataSource")
    public DataSource dataSourceTest() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(classname);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //开发环境
    @Profile("dev")
    @Bean(name = "devDataSource")
    public DataSource dataSourceDev() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(classname);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    //生产环境
    @Profile("prod")
    @Bean(name = "prodDataSource")
    public DataSource dataSource() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(url);
        dataSource.setDriverClass(classname);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
