package cn.wzw.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author Wangzhiwen
 * @ClassName DataSourceConfig
 * @Description
 * @Date 2019/6/11 17:14
 * @Version 1.0
 */
@Configuration
public class DataSourceConfig {
    //数据源一
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource primaryDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    //数据源二，主
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "datasource.secondary")
    @Primary
    public DataSource secondaryDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
