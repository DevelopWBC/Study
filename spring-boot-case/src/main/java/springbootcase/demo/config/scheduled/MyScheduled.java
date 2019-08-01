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
      *@date 2019/5/15 13:54
      *@param []
      *@return void
    */
    @Scheduled(cron = "0 0 1 * * ?")
    public void scheduled(){
        System.out.println("通过scheduled实现的定时任务已被触发。。。。");
        System.out.println("Dev工具部署已生效。。。");
    }
}
