package springbootcase.demo.config.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author Wangzhiwen
 * @ClassName MyScheduled
 * @Description：使用spring自带的scheduled任务框架，需要添加spring-context-support依赖
 * @Date 2019/5/15 13:51
 * @Version 1.0
 */
@Component
public class MyScheduled {
    /**
      *@author Wangzhiwen
      *@description:使用注解，书写cron表达式
    */
    /**
     * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）.
     * 0 * * * * MON-FRI
     *  【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     *  【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
     *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduled(){
        System.out.println("通过scheduled实现的定时任务已被触发。。。。");
        System.out.println("Dev工具部署已生效。。。");
    }
}
