package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot整合jsp
 * 1.继承springboot父工程
 * 2.pom文件中加入jstl标签依赖
 * 3.在resource目录下，新建springboot配置文件，application.properties
 * 4.创建main/webapp/WEB-INF/jsp目录
 * 5.编写springboot启动类
 * @author Wangzhiwen
 *
 */
@SpringBootApplication
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
