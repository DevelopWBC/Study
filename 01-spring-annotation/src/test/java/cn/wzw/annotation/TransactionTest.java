package cn.wzw.annotation;

import cn.wzw.config.TransactionConfig;
import cn.wzw.pojo.Person;
import cn.wzw.service.PersonService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author Wangzhiwen
 * @ClassName TransactionTest
 * @Description
 * @Date 2019/5/27 15:34
 * @Version 1.0
 */
public class TransactionTest {
    @Test
    public void test(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        PersonService bean = context.getBean(PersonService.class);
        Person person = new Person();
        person.setName("无正文");
        person.setAge(22);
        bean.insertPerson(person);
        System.out.println("测试。。。。。。。。。。。。");
        context.close();
    }
}
