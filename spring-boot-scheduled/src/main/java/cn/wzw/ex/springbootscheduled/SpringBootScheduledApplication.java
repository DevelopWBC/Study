package cn.wzw.ex.springbootscheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
  *@author Wangzhiwen
  *@description：定时器的实现，使用spring3.0之后自带的定时器框架。scheduled
  *@date 2019/5/15 13:45
  *@param
  *@return
*/
@SpringBootApplication
//开启定时器注解
@EnableScheduling
public class SpringBootScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduledApplication.class, args);
    }

}
