package cn.wzw.annotation;

import cn.wzw.AOP.Target;
import cn.wzw.config.AOPConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Wangzhiwen
 * @ClassName AOPTest
 * @Description
 * @Date 2019/5/27 13:57
 * @Version 1.0
 */
public class AOPTest {

    private AnnotationConfigApplicationContext context;
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(AOPConfig.class);
    }


    @Test
    public void test1(){
        Target bean = context.getBean(Target.class);
        String service = bean.service("结果集");
        System.out.println(service);
    }
}
