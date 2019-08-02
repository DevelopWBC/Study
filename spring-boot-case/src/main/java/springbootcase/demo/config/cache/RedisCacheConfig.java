package springbootcase.demo.config.cache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import springbootcase.demo.pojo.data.test2.User;

import java.net.UnknownHostException;

/**
 * @Author Wangzhiwen
 * @ClassName RedisCacheConfig
 * @Description
 * @Date 2019/8/1 10:08
 * @Version 1.0
 */
@Configuration
public class RedisCacheConfig {
    /**
     * redis缓存也可以使用spring提供的缓存注解。
     * 1、作用及使用方法都和默认的simple缓存一样，
     * 2、data-redis默认使用JDK的序列化策略，所以对应的pojo要实现Serializable接口。
     * 3、加载redis缓存组件时，默认提供了两个操作redis的模板对象。
     *      public RedisTemplate<Object, Object> redisTemplate
     *          K.V值都是object类型
     *      public StringRedisTemplate stringRedisTemplate
     * 4、使用默认的序列化机制和操作模板时，存入的的对象数据在redis中是16进值的。可以自己定义redisTemplate，选择json格式的序列化策略
     * 5、自定义模板注入工厂连接，返回RedisTemplate对象。设置序列化策略
     * 6、自定义缓存规则，生成RedisCacheManager对象。
     */
    @Bean
    public RedisTemplate<String, User> userRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        // RedisConnectionFactory 会自动注入，
        RedisTemplate<String, User> template = new RedisTemplate<>();
        Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<>(User.class);
        template.setDefaultSerializer(serializer);
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /*@Primary
    @Bean
    public RedisCacheManager employeeCacheManager(RedisTemplate<Object, User> userRedisTemplate){
        RedisCacheManager cacheManager = new RedisCacheManager(userRedisTemplate);
        cacheManager
    }*/
}
