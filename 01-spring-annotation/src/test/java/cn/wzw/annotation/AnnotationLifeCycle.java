package cn.wzw.annotation;

import cn.wzw.config.LifeCycleConfig;
import cn.wzw.pojo.LifeCycleBean;
import cn.wzw.pojo.One;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Wangzhiwen
 * @ClassName AnnotationLifeCycle
 * @Description：注解控制bean的生命周期
 * @Date 2019/5/24 14:00
 * @Version 1.0
 */
public class AnnotationLifeCycle {
    private AnnotationConfigApplicationContext context;

    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println("容器创建完成...");
    }

    @After
    public void destory(){
        System.out.println("容器即将关闭...");
        context.close();
        System.out.println("容器已关闭...");
        System.out.println("===================================");
    }

    //在注解@Bean中使用属性完成
    @Test
    public void test1(){
        LifeCycleBean bean = context.getBean(LifeCycleBean.class);
        System.out.println(bean.getClass());
        System.out.println("===================================");
    }

    //实现接口完成
    @Test
    public void test2(){
        Object bean2 = context.getBean("bean2");
        System.out.println(bean2.getClass());
        System.out.println("===================================");
    }

    //JSR250注解
    @Test
    public void test3(){
        Object bean3 = context.getBean("bean3");
        System.out.println(bean3.getClass());
        System.out.println("===================================");
    }

    @Test
    public void test4(){
        One bean = context.getBean(One.class);
        System.out.println("结束");
    }
}
