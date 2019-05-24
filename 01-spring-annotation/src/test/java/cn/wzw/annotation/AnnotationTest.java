package cn.wzw.annotation;

import cn.wzw.config.MyConfig;
import cn.wzw.pojo.Person;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Wangzhiwen
 * @ClassName AnnotationTest
 * @Description：spring基本注解的使用
 * @Date 2019/5/23 11:15
 * @Version 1.0
 */
public class AnnotationTest {

    private ApplicationContext  context;

    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(MyConfig.class);
    }

    //常用组件注册注解的测试使用
    @Test
    public void test1(){
        //Person bean = context.getBean(Person.class); 不唯一，扫描时创建一个。通过注解又创建一个，所以根据类型无法获取是哪一个对象
        //System.out.println(bean);
        Person person = (Person)context.getBean("zhangsan");
        System.out.println(person);
        String[] names = context.getBeanDefinitionNames();
        out(names);
    }

    //@Import注解的测试使用
    @Test
    public void test2(){
        //ImportBean bean = context.getBean(ImportBean.class);
        //ImportSertceorBean bean1 = context.getBean(ImportSertceorBean.class);
        String[] names = context.getBeanDefinitionNames();
        out(names);
    }

    //bean工厂生产对象
    @Test
    public void test3(){
        Object bean = context.getBean("myFactoryBean"); //还是需要先生成工厂对象
        System.out.println(bean.getClass());
        Object bean1 = context.getBean("&myFactoryBean");
        System.out.println(bean1.getClass());
        out(context.getBeanDefinitionNames());
    }

    //打印出IOC容器中所有的bean对象名称
    public void out(String[] names){
        for (String name : names) {
            System.out.println(name);
        }
    }
}
