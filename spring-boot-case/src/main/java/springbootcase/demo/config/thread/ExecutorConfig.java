package springbootcase.demo.config.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Wangzhiwen
 * @ClassName ExecutorConfig
 * @Description：spring的线程池配置管理
 * @Date 2019/7/22 14:54
 * @Version 1.0
 */
@Configuration
@EnableAsync
@ConfigurationProperties(prefix = "async")
public class ExecutorConfig {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExecutorConfig.class);

    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private int keepAlive;


    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public int getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(int keepAlive) {
        this.keepAlive = keepAlive;
    }

    /*配置解释
        当一个任务通过execute(Runnable)方法欲添加到线程池时：
        1、 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
        2、 如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
        3、 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。
        4、 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。
        也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
        5、 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数
    */

    @Bean
    public Executor async(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("async-"); // 设置线程前缀
        executor.setCorePoolSize(corePoolSize); // 设置线程核心数
        executor.setMaxPoolSize(maxPoolSize);   // 设置最大数量
        executor.setQueueCapacity(queueCapacity); //设置队列任务最大数
        executor.setKeepAliveSeconds(keepAlive); // 设置时间
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());  // 任务为执行时的处理策略
        executor.initialize(); // 初始化
        return executor;
    }
}
