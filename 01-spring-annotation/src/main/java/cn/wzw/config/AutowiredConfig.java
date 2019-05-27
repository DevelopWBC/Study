package cn.wzw.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Wangzhiwen
 * @ClassName AutowiredConfig
 * @Description：自动注入的实现
 * @Date 2019/5/27 10:16
 * @Version 1.0
 */
@Configuration
@ComponentScan({"cn.wzw.controller","cn.wzw.service","cn.wzw.dao"})
public class AutowiredConfig {


}
