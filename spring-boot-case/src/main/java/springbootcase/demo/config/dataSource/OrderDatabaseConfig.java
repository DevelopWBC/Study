package springbootcase.demo.config.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
  *@author Wangzhiwen
  *@description
  *@date 2019/6/12 11:20
  *@param
  *@return
*/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "test1EntityManagerFactory",
        transactionManagerRef = "test1TransactionManager",
        basePackages = {"springbootcase.demo.dao.test1"})

public class OrderDatabaseConfig {
    @Autowired
    private HibernateProperties hibernateProperties;
    @Resource
    @Qualifier("test1DataSource")
    private DataSource orderDataSource;

    @Primary
    @Bean(name = "test1EntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return orderEntityManagerFactory(builder).getObject().createEntityManager();
    }

    @Resource
    private JpaProperties jpaProperties;


    /**
     * 设置实体类所在位置
     */
    @Primary
    @Bean(name = "test1EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean orderEntityManagerFactory(EntityManagerFactoryBuilder builder) {

        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder
                .dataSource(orderDataSource)
                .packages("springbootcase.demo.pojo.data.test1")
                .persistenceUnit("test1Persistence")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "test1TransactionManager")
    public PlatformTransactionManager orderTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(orderEntityManagerFactory(builder).getObject());
    }
}