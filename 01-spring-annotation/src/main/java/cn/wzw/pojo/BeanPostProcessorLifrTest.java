package cn.wzw.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @Author Wangzhiwen
 * @ClassName BeanPostProcessorLifrTest
 * @Description * 后置处理器：初始化前后进行处理工作
 *              * 将后置处理器加入到容器中
 * @Date 2019/5/24 14:34
 * @Version 1.0
 */
@Service
public class BeanPostProcessorLifrTest implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization...初始化前的处理...."+beanName+"=>"+bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization...初始化后的处理....."+beanName+"=>"+bean);
        System.out.println("=========================");
        return bean;
    }
}
