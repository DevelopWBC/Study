package cn.wzw.pojo;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author Wangzhiwen
 * @ClassName MyFactoryBean
 * @Description
 * @Date 2019/5/24 13:12
 * @Version 1.0
 */
public class MyFactoryBean implements FactoryBean<FactoryBeanTest> {

    //创建bean，装配到IOC容器中
    @Override
    public FactoryBeanTest getObject() throws Exception {
        return new FactoryBeanTest();
    }

    //返回bean类型
    @Override
    public Class<?> getObjectType() {
        return FactoryBeanTest.class;
    }

    //是否是单例，默认为false
    @Override
    public boolean isSingleton() {
        return true;
    }
}
