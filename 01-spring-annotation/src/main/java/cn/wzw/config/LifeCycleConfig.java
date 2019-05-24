package cn.wzw.config;

import cn.wzw.pojo.LifeCycleBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Wangzhiwen
 * @ClassName LifeCycleConfig
 * @Description：注解方式控制bean的生命周期
 * @Date 2019/5/24 13:29
 * @Version 1.0
 */
@Configuration
@ComponentScan("cn.wzw.pojo")
public class LifeCycleConfig {
    //1.使用@Bean注解
/*    @Bean(value = "bean1",initMethod = "init" , destroyMethod = "destory")
    public LifeCycleBean lifeCycleBean(){
        System.out.println("===========================");
        System.out.println("未生成bean..");
        LifeCycleBean lifeCycleBean = new LifeCycleBean("wzw", "start");
        System.out.println("创建了bean对象..");
        System.out.println("===========================");
        return lifeCycleBean;
    }*/

    //2,
    @Bean(value = "bean2")
    public LifeCycleBean lifeCycleBean2(){
        System.out.println("===========================");
        System.out.println("未生成bean..");
        LifeCycleBean lifeCycleBean = new LifeCycleBean("wzw", "start");
        System.out.println("创建了bean对象..");
        System.out.println("===========================");
        return lifeCycleBean;
    }
    //3.属于JSR250注解实现，java自带

/*    @Bean(value = "bean3")
    public LifeCycleBean lifeCycleBean3(){
        System.out.println("===========================");
        System.out.println("未生成bean..");
        LifeCycleBean lifeCycleBean = new LifeCycleBean("wzw", "start");
        System.out.println("创建了bean对象..");
        System.out.println("===========================");
        return lifeCycleBean;
    }*/

}
