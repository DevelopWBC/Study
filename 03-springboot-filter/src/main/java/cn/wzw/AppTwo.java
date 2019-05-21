package cn.wzw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import cn.wzw.filter.SecondFilter;
import cn.wzw.servlet.SecondServlet;

/**
 * springboot整合filter的第二种方式：不使用注解使用方法来注册获取实例
 * @author Wangzhiwen
 *
 */
@SpringBootApplication
public class AppTwo {
	public static void main(String[] args) {
		SpringApplication.run(AppTwo.class, args);
	}
	
	@Bean
	public ServletRegistrationBean<SecondServlet> getServlet(){
		ServletRegistrationBean<SecondServlet> bean = new ServletRegistrationBean<SecondServlet>(new SecondServlet());
		bean.addUrlMappings("/second");
		return bean;
	}
	@Bean
	public FilterRegistrationBean<SecondFilter> getFilter(){
		FilterRegistrationBean<SecondFilter> bean = new FilterRegistrationBean<SecondFilter>(new SecondFilter());
		bean.addUrlPatterns("/second");
		return bean;
	}
}
