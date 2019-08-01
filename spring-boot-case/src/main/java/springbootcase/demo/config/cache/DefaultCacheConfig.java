package springbootcase.demo.config.cache;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author Wangzhiwen
 * @ClassName DefaultCacheConfig
 * @Description
 * @Date 2019/8/1 10:08
 * @Version 1.0
 */
@Configuration
public class DefaultCacheConfig {
    /**
     * 使用spring默认装配的缓存组件，ConcurrentMapCacheManager。自定义配置缓存key的值
     */
    @Bean
    public KeyGenerator systemKeyGenerator(){
        return new KeyGenerator(){
            /**
             * target：目标对象
             * method：方法对象，可以获取方法相关属性
             * params：方法中的参数数组
             */
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return method.getName() + ":" + Arrays.asList(params).get(0).toString();
            }
        };
    }
}
