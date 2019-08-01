package springbootcase.demo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * springboot整合servlet的第一中方式：采用注解配置
 * 原始需要在web.xml中配置servlet信息：
 * <servlet>
 * 	<servlet-name>FirstServlet</servlet-name>
 * 	<servlet-class></servlet-class>
 * </servlet>
 * <servlet-mapping>
 * 	<servlet-name>FirstServlet</servlet-name>
 * 	<servlet-urlParent>/first</servlet-urlParent>
 * </servlet-mapping>
 * @author Wangzhiwen
 *
 */
@WebServlet(name="FirstServlet",urlPatterns="/first")
public class FirstServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("成功访问FirstServlet.....");
	}
}
