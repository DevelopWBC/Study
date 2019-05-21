package cn.wzw.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;

@WebFilter(filterName="CountFilter",urlPatterns="/count")
public class CountFilter implements Filter {
	private ServletContext app;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//实例化app
		app=filterConfig.getServletContext();
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		//统计访问本站的次数
		//取出app
		Map<String, Object> map =  (Map<String, Object>) app.getAttribute("map");
		//获取IP地址
		HttpServletRequest request = (HttpServletRequest) req;
		String ip = request.getRemoteAddr();
		//判断是否是第一次访问，若不是则加一，若是则添加赋值加一
		if(!map.containsKey(ip)){
			map.put(ip, 1);
		}else{
			int count = (int) map.get(ip);
			map.put(ip, count+1);
		}
		//把新的map信息存入app中
		app.setAttribute("map", map);
		//放行
		chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		Filter.super.destroy();
	}

}
