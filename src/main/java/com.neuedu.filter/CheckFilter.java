package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class CheckFilter
 */
@WebFilter(/*"/view/*"*/)
public class CheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest _request, ServletResponse _response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)_request;
		HttpServletResponse response = (HttpServletResponse) _response;
		//得到会话域,服务器会根据已写到浏览器的JESSIONID查询到这个会话并加入到会话
		HttpSession session = request.getSession();
	
		Object o = session.getAttribute("token");
		Object o1 = session.getAttribute("acc");
		
		if(o!=null&&o1!=null) {
			String token = (String) o;
			Account account = (Account) o1;
			LoginService ls = new LoginServiceImpl();
			String data_token = ls.findTokenByAccountId(account.getId());
			if(data_token!=null) {
				if(token.equals(data_token)) {
					//有效的token
					chain.doFilter(request, response);
					return;
				}
			}
			
		}
		
	 response.sendRedirect("http://localhost:8080/Serverlet01/Login.html");
		
	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
