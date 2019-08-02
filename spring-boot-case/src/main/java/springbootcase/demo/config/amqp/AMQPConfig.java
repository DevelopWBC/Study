package springbootcase.demo.config.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author Wangzhiwen
 * @ClassName AMQPConfig
 * @Description
 * @Date 2019/8/2 14:04
 * @Version 1.0
 */
@Configuration
@PropertySource(value = "classpath:/rabbitmq.properties")
public class AMQPConfig {
    /**
     * 消息中间件的配置类
     */
    // 配置序列换转换器，默认的是JDK序列化
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Value("${USER.ADD.QUEUE}")
    private String userAdd;

    /**
     * 配置自定义的队列queue和交换器exchange
     */
    @Bean
    public Queue userQueue(){
        // new Queue(String name); new Queue(String name,boolean flag)
        // 队列名称，是否持久化消息
        return new Queue(userAdd,true);
    }

    /**
     * 交换器名称
     */
    public static class Exchange{
        public static String DIRECT = "amq.direct";
        public static String FANOUT = "amq.fanout";
        public static String TOPIC = "amq.topic";
    }

    public static class RoutingKey{
       // public static String
    }
}
