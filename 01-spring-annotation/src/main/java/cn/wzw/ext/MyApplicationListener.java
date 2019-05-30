package cn.wzw.ext;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author Wangzhiwen
 * @ClassName MyApplicationListener
 * @Description
 * @Date 2019/5/28 9:58
 * @Version 1.0
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    //监听事件ApplicationEvent，
    @Override
    public void onApplicationEvent(ApplicationEvent event) {

    }
}
