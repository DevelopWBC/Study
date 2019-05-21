package cn.wzw.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * springboot整合filter的第一中方式：使用注解来注册filter对象
 * @author Wangzhiwen
 * 
 * <fiter>
 * 	<fiter-name>FirstFilter</fiter-name>
 * 	<filter-class>cn.wzw.filter.FistFilter</filter-class>
 * </filter>
 * <filter-mapping>
 * 	<filter-name>FirstFilter</filter-name>
 * 	<url-pattern>/</url-pattern>
 * </filter-mapping>
 *
 */
@WebFilter(filterName="FirstFilter",urlPatterns="/first")
public class FirstFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
			System.out.println("进去过滤器");
			arg2.doFilter(arg0, arg1);//放行
			System.out.println("离开过滤器");
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		System.out.println("oooooooo");
	}
	
}
