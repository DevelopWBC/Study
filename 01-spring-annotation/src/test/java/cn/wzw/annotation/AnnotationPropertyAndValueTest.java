package cn.wzw.annotation;

import cn.wzw.config.PropertiesAndValueConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author Wangzhiwen
 * @ClassName AnnotationPropertyAndValueTest
 * @Description
 * @Date 2019/5/24 17:15
 * @Version 1.0
 */
public class AnnotationPropertyAndValueTest {

    private AnnotationConfigApplicationContext context;
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(PropertiesAndValueConfig.class);
    }
    @After
    public void destory(){
        context.close();
    }

    @Test
    public void test1(){
        ConfigurableEnvironment environment = context.getEnvironment();
        String name = environment.getProperty("user.name");
        System.out.println(name);
    }
}
