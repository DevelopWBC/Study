package cn.wzw.annotation;

import cn.wzw.config.ProfileConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

/**
 * @Author Wangzhiwen
 * @ClassName ProfileTest
 * @Description：测试spring对多环境配置的支持
 * @Date 2019/5/29 11:10
 * @Version 1.0
 */
public class ProfileTest {
    //1、使用命令行动态参数: 在虚拟机参数位置加载 -Dspring.profiles.active=test
    //2、代码的方式激活某种环境；
    @Test
    public void test(){
        //1.激活环境后再刷新配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();
        String[] beanNamesForType = context.getBeanNamesForType(DataSource.class);
        for (String name :  beanNamesForType){
            System.out.println(name);
        }


    }
}
