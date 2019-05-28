package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @Author Wangzhiwen
 * @ClassName AServlet
 * @Description：servlet3.0及以上使用注解开发，不需要web.xml文件
 * @Date 2019/5/28 10:37
 * @Version 1.0
 */
@WebServlet(name = "AServlet",urlPatterns = "/a")
public class AServlet extends HttpServlet {

}
