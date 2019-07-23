package cn.wzw.springBootKnowledgEextension.config;

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
