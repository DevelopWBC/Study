package cn.wzw.importTest;

import cn.wzw.pojo.ImportBeanDefinitionRegistrarBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author Wangzhiwen
 * @ClassName MyImportBeanDefinitionRegistrar
 * @Description：@Import注解导入bean对象到容器中value属性的第三种方式，实现ImportBeanDefinitionRegistrar接口。在bean工厂中注册bean对象
 * @Date 2019/5/24 11:49
 * @Version 1.0
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    //AnnotationMetadata：当前写有@Import注解类的所有注解信息
    //BeanDefinitionRegistry：手动注入bea对象
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //生成definition对象，指定bean类型
        RootBeanDefinition definition = new RootBeanDefinition(ImportBeanDefinitionRegistrarBean.class);
        //注册bean到容器中，指定bean名称和definition对象
        registry.registerBeanDefinition("起bean名称",definition);
    }
}
