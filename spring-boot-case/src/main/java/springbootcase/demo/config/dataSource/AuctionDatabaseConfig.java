package springbootcase.demo.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author Wangzhiwen
 * @ClassName AuctionDatabaseConfig
 * @Description
 * @Date 2019/6/12 11:26
 * @Version 1.0
 */
@Configuration
@MapperScan(basePackages = "springbootcase.demo.dao.test2",sqlSessionFactoryRef = "test2SqlSessionFactory")
@EnableTransactionManagement
public class AuctionDatabaseConfig {

    @Autowired
    @Qualifier("test2DataSource")
    private DataSource test2DataSource;

    @Primary
    @Bean(name = "test2TransactionManager")
    public DataSourceTransactionManager test2TransactionManager(){
        return new DataSourceTransactionManager(test2DataSource);
    }

    /**
     * 使用mybatis配置多个数据源时，每一个sqlSession都是独立的。所以不能依靠只指定一个配置文件，
     * 在springboot配置文件中指定一份无效，可以直接在SQLSession中设置指定位置加载。
     * 也可以使用注解向不同的SQLSession中注入不同的属性值。
     */
    @Primary
    @Bean(name = "test2SqlSessionFactory")
    public SqlSessionFactory test2SqlSessionFactory(@Qualifier("test2DataSource") DataSource test2DataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(test2DataSource);
        //sessionFactory.setTypeAliasesPackage("springbootcase.demo.pojo.test2");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mybatis/mapper/test2/*.xml"));
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource("classpath:/mybatis/config/mybatisConfig.xml"));
        return sessionFactory.getObject();
    }
}
