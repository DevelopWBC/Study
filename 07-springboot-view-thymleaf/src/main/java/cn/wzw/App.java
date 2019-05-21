package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot整合Thymeleaf
 * 1.添加springboot-web和Thymeleaf的启动类
 * 2.springboot要求所有模板必须放在src/main/resource/templates这个目录下。
 * 3.创建html文件
 * 4.根据Thymeleaf的语法规则可以获取request域中存的对象信息。
 * 	 如：	< span th:text="${key}"></span>
 * 	取出集合信息：<#list 集合名称(list) as 单个对象名称(obj)></#list>
 * 				获取下标：${obj_index} 判断：${obj == ''}
 * 				日期格式化：${date?date}日期 ${date?time} 时间 ${date?datetime} 日期加时间 自定义${date?string('yyy/MM/dd:hh:mm:ss')}
 * @author Wangzhiwen
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
