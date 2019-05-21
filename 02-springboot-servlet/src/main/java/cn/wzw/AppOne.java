package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 编写springboot的启动类，开启扫描。扫描@webServlet注解，并注册实例。
 * @author Wangzhiwen
 *
 */

@SpringBootApplication
@ServletComponentScan
public class AppOne {
	
	public static void main(String[] args) {
		SpringApplication.run(AppOne.class, args);
	}
}
