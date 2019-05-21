package cn.wzw.servlet;

import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="count",urlPatterns="/count")
public class CountServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			Map<String, Object> map = (Map<String, Object>) req.getServletContext().getAttribute("map");
			req.setAttribute("map", map);
			Set<java.util.Map.Entry<String, Object>> set =  map.entrySet();
			Integer sum = 0;
			for (java.util.Map.Entry<String, Object> entry : set) {
				String ip = entry.getKey();
				Integer count = (Integer) entry.getValue();
				sum += count;
				System.out.println("用户"+ip+"访问了："+count+"次！");
			}
			System.out.println("总共被访问了"+sum+"次！");
//			req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
