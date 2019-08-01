package springbootcase.demo.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("进入过滤器二");
		arg2.doFilter(arg0, arg1);//放行
		System.out.println("离开过滤器二");
	}

}
