package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.DButils;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(/*"/Login.html"*/)
public class LoginFilter implements Filter {

  

	/**
     * Default constructor. 
     */
    public LoginFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  req = (HttpServletRequest)request;
		HttpServletResponse reps = (HttpServletResponse)response;
		String username =null;
		String password = null;
		Cookie[] cookies = req.getCookies();
		LoginService ls = new LoginServiceImpl();
		if(cookies!=null) {
			for(Cookie c:cookies) {
				if(c.getName().equals("username")) {	
					username = c.getValue();
				}
				if(c.getName().equals("password")) {
					password = c.getValue();
				
				}
			}
		}
		
		if(username!=null&&password!=null&!username.equals("")&&!password.equals("")) {
	  		Account acc = ls.LogonLogic(username,password);
			if(acc!=null) {
			
				request.getRequestDispatcher("view/frameset.jsp").forward(request, response);		
			}else {
				chain.doFilter(request, response);
			}
		}
		else {
			chain.doFilter(request, response);
			
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
