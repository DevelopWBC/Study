package springbootcase.demo.manager;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springbootcase.demo.config.amqp.AMQPConfig;

/**
 * @Author Wangzhiwen
 * @ClassName RabbitMQManager
 * @Description
 * @Date 2019/8/2 15:34
 * @Version 1.0
 */
@Component
public class RabbitMQManager {
    /**
     * rabbitmq消息中间件的基本使用
     */
    private static RabbitTemplate rabbitTemplate;
    private static AmqpAdmin amqpAdmin;
    private static Queue userQueue;

    @Autowired
    public RabbitMQManager(RabbitTemplate rabbitTemplate,AmqpAdmin amqpAdmin,Queue userQueue){
        RabbitMQManager.rabbitTemplate = rabbitTemplate;
        RabbitMQManager.amqpAdmin = amqpAdmin;
        RabbitMQManager.userQueue = userQueue;
    }

    /**
     * 手动发送数据
     */
    public static void sendMsg(Object msg){
        // public void convertAndSend(String exchange, String routingKey, final Object object)
        rabbitTemplate.convertAndSend(AMQPConfig.Exchange.DIRECT,"user.add",msg);
    }

    /**
     * 未使用注解监听，手动获取数据
     */
    public static Object receive(String queueName){
        Message receive = rabbitTemplate.receive(queueName);
        byte[] body = receive.getBody();
//        Object o = rabbitTemplate.receiveAndConvert("user.quque");
//        rabbitTemplate.receiveAndConvert("user.add", User.class);
        return body;
    }
}
