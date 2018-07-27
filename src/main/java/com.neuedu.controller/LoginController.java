package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.LoginService;
import com.neuedu.service.impl.LoginServiceImpl;
import com.neuedu.utils.MD5Utils;

/**
 * Servlet implementation class LoginController
 */



@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService ls = new LoginServiceImpl();
		
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		Account acc = ls.LogonLogic(username, MD5Utils.GetMD5Code(password));
		//ҳ����ת
		if(acc!=null) {
			
			Cookie cookie = new Cookie("username", username);	
			cookie.setMaxAge(1800);
			response.addCookie(cookie);
			Cookie pwd_cookie = new Cookie("password", MD5Utils.GetMD5Code(password));	
			pwd_cookie.setMaxAge(1800);
			response.addCookie(pwd_cookie);
			
			//����token ��׼����ŵ����ݿ�
			long time = System.currentTimeMillis();
			String token = MD5Utils.GetMD5Code(username+password+time);
			ls.addToken(acc, token);	
			//�����Ự�򣬰�acc��token�ŵ�����
			HttpSession session = request.getSession();
		//	session.setMaxInactiveInterval(60);
			session.setAttribute("token", token);
			session.setAttribute("acc", acc);
				
			request.getRequestDispatcher("view/frameset.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("view/fail.jsp").forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
