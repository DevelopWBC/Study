package cn.wzw.ex.springbootexception.service;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author Wangzhiwen
 * @ClassName Run
 * @Description
 * @Date 2019/7/17 11:37
 * @Version 1.0
 */
@Component
public class Run {

    @PostConstruct
    public void run(){
        System.out.println("启动初始化完成后执行方法");
    }
}
