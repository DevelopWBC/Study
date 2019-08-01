package springbootcase.demo.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author Wangzhiwen
 * @ClassName DataSourceConfig
 * @Description
 * @Date 2019/6/11 17:14
 * @Version 1.0
 */
//@Configuration
public class DataSourceConfig {
    //数据源一
    //order库，为主
    @Primary
    @Bean(name = "orderDataSource")
    @Qualifier("orderDataSource")
    @ConfigurationProperties(prefix = "datasource.order")
    public DataSource orderDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    //数据源二，主
    //middleService库
    @Bean(name = "middleServiceDataSource")
    @Qualifier("middleServiceDataSource")
    @ConfigurationProperties(prefix = "datasource.middle")
    public DataSource middleServiceDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    //auction库
    @Bean(name = "auctionDataSource")
    @Qualifier("auctionDataSource")
    @ConfigurationProperties(prefix = "datasource.auction")
    public DataSource auctionDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }
}
