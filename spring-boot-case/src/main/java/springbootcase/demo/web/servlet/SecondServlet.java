package springbootcase.demo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**	
 * springboot整合servlet的第二种方式，不使用注解在启动类中使用方法来注册servlet实例。
 * @author Wangzhiwen
 *
 */
public class SecondServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			System.out.println("SecondServlet。。。。");
	}
}
