package cn.wzw.ex.springbootscheduled.quartz;

import cn.wzw.ex.springbootscheduled.service.TestService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author Wangzhiwen
 * @ClassName MyQuartz
 * @Description：使用Quartz框架实现任务定时器并和springboot整合
 * @Date 2019/5/15 14:43
 * @Version 1.0
 */
public class MyQuartz implements Job {

    @Autowired
    private TestService service;
    /**
      *@author Wangzhiwen
      *@description:定时任务
      *@date 2019/5/15 14:46
      *@param [context]
      *@return void
    */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        service.service();
        System.out.println("quartz实现定时任务。。。");
    }
}
