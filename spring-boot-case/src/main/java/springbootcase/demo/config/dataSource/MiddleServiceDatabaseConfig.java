package springbootcase.demo.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
  *@author Wangzhiwen
  *@description
  *@date 2019/6/12 11:30
  *@param
  *@return
*/
@Configuration
@MapperScan(basePackages = "springbootcase.demo.dao.test3",sqlSessionFactoryRef = "test3SqlSessionFactory")
@EnableTransactionManagement
public class MiddleServiceDatabaseConfig {

    @Autowired
    @Qualifier("test3DataSource")
    private DataSource test3DataSource;

    @Bean(name = "test3TransactionManager")
    public DataSourceTransactionManager test2TransactionManager(){
        return new DataSourceTransactionManager(test3DataSource);
    }

    @Bean(name = "test3SqlSessionFactory")
    public SqlSessionFactory test3SqlSessionFactory(@Qualifier("test3DataSource") DataSource test3DataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(test3DataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        /**
         * 指定mybatis配置文件的位置
         */
        //sessionFactory.setConfigLocation(resolver.getResource("classpath:/mybatis/config/*.xml"));
        /**
         * 指定mapper.xml文件的位置
         */
        //sessionFactory.setMapperLocations(resolver.getResources("classpath:/mybatis/mapper/test3/*.xml"));
        /**
         * todo:配置pojo类的别名扫描，在使用logback日志框架时会导致mybatis控制台输出乱码。尽量不使用别名，使用类路径全名称
         */
        //sessionFactory.setTypeAliasesPackage("springbootcase.demo.pojo.test3");
        /**
         * 在mybatis配置文件中可以设置的，也可以直接再手动设置。SqlSessionFactoryBean属性值
         */
        return sessionFactory.getObject();
    }

}
