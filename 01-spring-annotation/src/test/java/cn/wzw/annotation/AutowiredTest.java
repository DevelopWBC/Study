package cn.wzw.annotation;

import cn.wzw.config.AutowiredConfig;
import cn.wzw.dao.PersonDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Wangzhiwen
 * @ClassName AutowiredTest
 * @Description
 * @Date 2019/5/27 10:17
 * @Version 1.0
 */
public class AutowiredTest {

    //@Autowired
    //private PersonService personService;
    @Autowired
    private PersonDao personDao;

    private AnnotationConfigApplicationContext context;
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(AutowiredConfig.class);
    }
    @After
    public void destory(){
        context.close();
    }

    @Test
    public void test1(){
        //System.out.println(context.getBean(PersonService.class));
        //System.out.println(personService);
        System.out.println(personDao);
    }

}
