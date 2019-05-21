package cn.wzw.ex.springbootscheduled.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @Author Wangzhiwen
 * @ClassName QuartzConfig
 * @Description：Quartz配置类
 * @Date 2019/5/15 14:47
 * @Version 1.0
 */
@Configuration
public class QuartzConfig {
    //1.job，做什么
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        //生成job对象
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        //关联自定义的job实现类
        jobDetailFactoryBean.setJobClass(MyQuartz.class);
        return jobDetailFactoryBean;
    }
    //2.trigger，什么时候做
    //简单的Trigger对象
/*    @Bean
    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        //设置jobDetail对象
        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //设置时间，毫秒
        simpleTriggerFactoryBean.setRepeatInterval(1000);
        //设置重复次数
        simpleTriggerFactoryBean.setRepeatCount(10);
        return simpleTriggerFactoryBean;
    }*/

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        //使用cron表达式
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return cronTriggerFactoryBean;
    }

    //3.scheduler，什么时候做什么
/*
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        //设置trigger
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
        //设置jobFactory，自己实现的。可以注入
        schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
        return schedulerFactoryBean;
    }
*/

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean,MyAdaptableJobFactory myAdaptableJobFactory){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        schedulerFactoryBean.setJobFactory(myAdaptableJobFactory);
        return schedulerFactoryBean;
    }
}
