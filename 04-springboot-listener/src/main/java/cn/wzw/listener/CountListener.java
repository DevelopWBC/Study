package cn.wzw.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CountListener implements ServletContextListener {
	
	//监听启动
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//统计网站的被访问次数
		//监听项目启动时，获取application对象向其中设置属性值
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		sce.getServletContext().setAttribute("map", map);
	}
	
	//监听销毁
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
}
