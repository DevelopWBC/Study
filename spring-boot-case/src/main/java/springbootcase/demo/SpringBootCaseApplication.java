package springbootcase.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springbootcase.demo.web.filter.SecondFilter;
import springbootcase.demo.web.servlet.SecondServlet;
/**
 *  springboot下访问静态资源，有两种方式：
 *      1.放在clsspath目录下的static文件夹下。新建static目录，可以再往里面追加目录层次
        2.放在clsses目录下的webapp中。新建webapp
 *
 *  设置上传文件的大小，在classpath下创建application.properties文件。只能放这
 *  单个文件允许上传的最大容量   Spring.http.multipart.maxFileSize=100MB
 *  一个请求中允许上传的最大容量  Spring.http.multipart.maxRequestSize=200MB
 *
 *  springboot整合freemarker
 *   1.添加springboot-web和freemarker的启动类
 *   2.springboot要求所有模板必须放在src/main/resource/templates这个目录下。
 *   3.创建ftl文件
 *   4.根据freemarker的语法规则可以获取request域中存的对象信息。
 *   	类似于EL表达式 ${key.value}
 *   	取出集合信息：<#list 集合名称(list) as 单个对象名称(obj)></#list>
 *   			获取下标：${obj_index} 判断：${obj == ''}
 *   			日期格式化：${date?date}日期 ${date?time} 时间 ${date?datetime} 日期加时间 自定义${date?string('yyy/MM/dd:hh:mm:ss')}
 *
 *
 *  springboot整合Thymeleaf
 *  * 1.添加springboot-web和Thymeleaf的启动类
 *  * 2.springboot要求所有模板必须放在src/main/resource/templates这个目录下。
 *  * 3.创建html文件
 *  * 4.根据Thymeleaf的语法规则可以获取request域中存的对象信息。
 *  * 	 如：	< span th:text="${key}"></span>
 *  * 	取出集合信息：<#list 集合名称(list) as 单个对象名称(obj)></#list>
 *  * 				获取下标：${obj_index} 判断：${obj == ''}
 *  * 				日期格式化：${date?date}日期 ${date?time} 时间 ${date?datetime} 日期加时间 自定义${date?string('yyy/MM/dd:hh:mm:ss')}
  */
/**
 * 一、快速体验缓存
 * 		步骤：
 * 			1、开启基于注解的缓存 @EnableCaching
 * 			2、标注缓存注解即可
 * 				@Cacheable
 * 				@CacheEvict
 * 				@CachePut
 * 默认使用的是ConcurrentMapCacheManager==ConcurrentMapCache；将数据保存在	ConcurrentMap<Object, Object>中
 * 开发中使用缓存中间件；redis、memcached、ehcache；
 * 二、整合redis作为缓存
 * Redis 是一个开源（BSD许可）的，内存中的数据结构存储系统，它可以用作数据库、缓存和消息中间件。
 * 	1、安装redis：使用docker；
 * 	2、引入redis的starter
 * 	3、配置redis
 * 	4、测试缓存
 * 		原理：CacheManager===Cache 缓存组件来实际给缓存中存取数据
 *		1）、引入redis的starter，容器中保存的是 RedisCacheManager；
 *		2）、RedisCacheManager 帮我们创建 RedisCache 来作为缓存组件；RedisCache通过操作redis缓存数据的
 *		3）、默认保存数据 k-v 都是Object；利用序列化保存；如何保存为json
 *   			1、引入了redis的starter，cacheManager变为 RedisCacheManager；
 *   			2、默认创建的 RedisCacheManager 操作redis的时候使用的是 RedisTemplate<Object, Object>
 *   			3、RedisTemplate<Object, Object> 是 默认使用jdk的序列化机制
 *      4）、自定义CacheManager；
 *
 */

/**
 * 消息自动配置
 *  1、RabbitAutoConfiguration
 *  2、有自动配置了连接工厂ConnectionFactory；
 *  3、RabbitProperties 封装了 RabbitMQ的配置
 *  4、 RabbitTemplate ：给RabbitMQ发送和接受消息；
 *  5、 AmqpAdmin ： RabbitMQ系统管理功能组件;
 *  	AmqpAdmin：创建和删除 Queue，Exchange，Binding
 *  6、@EnableRabbit +  @RabbitListener 监听消息队列的内容
 *
 */
@SpringBootApplication
@ServletComponentScan // 编写springboot的启动类，开启扫描。扫描@webServlet注解，并注册实例。
@EnableScheduling  // 开启定时任务
@EnableConfigurationProperties
@EnableCaching // 开启缓存注解，自动加载装配缓存实现类
@EnableRabbit // 开启基于注解的RabbitMQ模式。@RabbitMQListener(被监听的队列名称)
@EnableWebSecurity // 开启security安全
public class SpringBootCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCaseApplication.class, args);
    }

    /**
     * springboot整合servlet的第二种方式：在启动类中使用方法注册获取servlet实例
     */
    @Bean
    public ServletRegistrationBean getBean(){
        ServletRegistrationBean bean = new ServletRegistrationBean<SecondServlet>(new SecondServlet());
        bean.addUrlMappings("/second");
        return bean;
    }

    /**
     * springboot整合filter的第二种方式：不使用注解使用方法来注册获取实例
     */
    @Bean
    public FilterRegistrationBean<SecondFilter> getFilter(){
        FilterRegistrationBean<SecondFilter> bean = new FilterRegistrationBean<SecondFilter>(new SecondFilter());
        bean.addUrlPatterns("/second");
        return bean;
    }
}
