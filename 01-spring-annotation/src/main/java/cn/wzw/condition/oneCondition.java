package cn.wzw.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author Wangzhiwen
 * @ClassName oneCondition
 * @Description：自定义Condition，在使用注解时满足条件才会创建bean对象
 * @Date 2019/5/23 14:51
 * @Version 1.0
 */
public class oneCondition implements Condition {

    //ConditionContext 上下文对象，包含环境
    //AnnotatedTypeMetadata 注释信息
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取bean工厂
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        //获取类加载器
        ClassLoader classLoader = context.getClassLoader();
        //获取上下文环境
        Environment environment = context.getEnvironment();
        //获取bean定义的注册类
        BeanDefinitionRegistry registry = context.getRegistry();

        String name = environment.getProperty("os.name");//获取系统名称
        if (name.contains("Windows"))
            return true;//放行
        return false;
    }
}
