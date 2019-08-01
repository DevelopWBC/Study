package springbootcase.demo.config.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @Author Wangzhiwen
 * @ClassName RootConfig
 * @Description
 * @Date 2019/7/30 16:42
 * @Version 1.0
 */

// 父容器，扫描除了controller的所有组件  springboot中不需要。启动类会扫描所有
//@Configuration
@ComponentScan(value = "springbootcase",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Controller.class)})
public class RootConfig {
}
