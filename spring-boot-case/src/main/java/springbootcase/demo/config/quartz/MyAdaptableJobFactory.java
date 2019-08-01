package springbootcase.demo.config.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Author Wangzhiwen
 * @ClassName MyAdaptableJobFactory
 * @Description：
 * 整合quartz框架时，job对象是由AdaptableJobFactory中的createJobInstance使用反射的方式创建。
 * 并未注册到IOC容器中，这里手动加入到IOC容器中。
 * @Date 2019/5/15 14:49
 * @Version 1.0
 */
@Component
public class MyAdaptableJobFactory extends AdaptableJobFactory {
    //使用此对象手动注入到IOC容器中
    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        autowireCapableBeanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
