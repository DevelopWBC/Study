package cn.wzw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author Wangzhiwen
 * @ClassName RootConfig
 * @Description
 * @Date 2019/5/28 16:32
 * @Version 1.0
 */
//父容器，扫描除了controller的所有组件
@Configuration
@ComponentScan(value = "cn.wzw",excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
public class RootConfig {
}
