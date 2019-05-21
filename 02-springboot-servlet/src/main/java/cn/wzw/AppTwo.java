package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import cn.wzw.servlet.SecondServlet;

/**
 * springboot整合servlet的第二种方式：在启动类中使用方法注册获取servlet实例
 * @author Wangzhiwen
 *
 */
@SpringBootApplication
public class AppTwo {
	public static void main(String[] args) {
		SpringApplication.run(AppTwo.class, args);
	}
	
	//方法获取实例
	@Bean
	public ServletRegistrationBean<SecondServlet> getBean(){
		ServletRegistrationBean bean = new ServletRegistrationBean<SecondServlet>(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
}
