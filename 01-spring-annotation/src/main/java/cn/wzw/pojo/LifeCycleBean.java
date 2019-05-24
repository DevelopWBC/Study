package cn.wzw.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author Wangzhiwen
 * @ClassName LifeCycleBean
 * @Description：注解方式控制bean的生命周期
 * @Date 2019/5/24 13:27
 * @Version 1.0
 */
public class LifeCycleBean implements InitializingBean, DisposableBean {
    private String start;
    private String end;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public LifeCycleBean() { }

    public LifeCycleBean(String start, String end) {
        System.out.println("===========================");
        System.out.println("bean未赋值...");
        this.start = start;
        this.end = end;
        System.out.println("bean已赋值...");
        System.out.println("===========================");
    }

    @Override
    public String toString() {
        return "LifeCycleBean{" +
                "start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    //在bean类中自定义初始
    public void init(){
        System.out.println("使用@Bean注解来实现bean对象的初始。。。。。");
        System.out.println("===========================");
    }

    ////在bean类中自定义销毁
    public void destory(){
        System.out.println("使用@Bean注解来实现bean对象的销毁。。。。。");
    }

    //实现DisposableBean接口，编写销毁逻辑。
    @Override
    public void destroy() throws Exception {
        System.out.println("实现DisposableBean接口，编写销毁逻辑...");
    }

    //实现InitializingBean接口，编写初始逻辑
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实现InitializingBean接口，编写初始逻辑...");
    }

    //使用JSR250注解完成	//对象创建并赋值之后调用
/*    @PostConstruct
    public void JSR250init(){
        System.out.println("对象创建并赋值之后调用，使用JSR250注解@PostConstruct完成初始");
    }

    @PreDestroy        //容器移除对象之前
    public void JS250Destory(){
        System.out.println("容器移除对象之前，使用JSR250注解@PostConstruct完成销毁");
    }*/
}
