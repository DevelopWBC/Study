package cn.wzw.ex.springbootscheduled.service;

import org.springframework.stereotype.Service;

/**
 * @Author Wangzhiwen
 * @ClassName TestService
 * @Description
 * @Date 2019/5/15 15:04
 * @Version 1.0
 */
@Service
public class TestService {
    public void service(){
        System.out.println("quartz的对象已经注入到IOC容器中。。。");
    }
}
