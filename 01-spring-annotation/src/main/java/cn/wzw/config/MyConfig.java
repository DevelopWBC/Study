package cn.wzw.config;

import cn.wzw.condition.TwoCondition;
import cn.wzw.condition.oneCondition;
import cn.wzw.importTest.MyImportBeanDefinitionRegistrar;
import cn.wzw.importTest.MyImportSelector;
import cn.wzw.pojo.*;
import org.springframework.context.annotation.*;

/**
 * @Author Wangzhiwen
 * @ClassName MyConfig
 * @Description：基于注解驱动开发时，所有配置信息一般都写在配置类中。
 * @Date 2019/5/23 11:05
 * @Version 1.0
 */
/*@Configuration 声明这是一个配置类
 *@ComponentScan 扫描指定路径下的包，bean对象。excludeFilters = {}排除
 *value:指定要扫描的包
 *excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
 *includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
 *FilterType.ANNOTATION：按照注解
 *FilterType.ASSIGNABLE_TYPE：按照给定的类型；
 *FilterType.ASPECTJ：使用ASPECTJ表达式
 *FilterType.REGEX：使用正则指定
 *FilterType.CUSTOM：使用自定义规则
 * useDefaultFilters = false 关闭默认的过滤规则
 */
@Import(value = {ImportBean.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})  //导入bean对象并注册到容器中，可以是指定类，可以是实现ImportSelector接口的类，可以是实现ImportBeanDefinitionRegistrar接口手动注入
@Configuration
/*@ComponentScan(value = "cn.wzw",includeFilters = {
        //@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Repository.class),
        //@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = PersonService.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = MyFilterType.class)
    },
useDefaultFilters = false)*/
public class MyConfig {
    //@Scope(value = "prototype")
    @Lazy //单例模式下，加入此注解实现bean对象的懒加载模式。只有获取对象时，才创建。
          //单实例bean：默认在容器启动的时候创建对象；
          //懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
    @Bean("zhangsan") //自定义id名称
    public Person person(){
        System.out.println("生成了person对象");
        return new Person("wzw",20);
    }

    @Conditional(value = {oneCondition.class})  //数组
    @Bean
    public One one(){
        System.out.println("Windows环境下才会被创建");
        return new One();
    }

    @Conditional(TwoCondition.class) //只有一个自定义的时候可以简写
    @Bean
    public Two two(){
        System.out.println("Linux环境下才会被创建。。");
        return new Two();
    }

    //使用bean工厂创建
    @Bean
    public MyFactoryBean myFactoryBean(){
        return new MyFactoryBean();
    }

}
