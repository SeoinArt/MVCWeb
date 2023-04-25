package common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class EncodeingFilter
 */
@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {

	public void destroy() {
	}

	/**
	 * 사전 처리나 사후 처리할 일이 있으면 doFilter()안에서 구현한다.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// post방식일 때 한글 처리
		
		request.setCharacterEncoding("utf-8");
//		System.out.println("EncodingFilter doFilter() 호출됨");
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
