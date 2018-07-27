package com.neuedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.UserOrder;
import com.neuedu.entity.UserOrderItem;
import com.neuedu.service.OrderService;
import com.neuedu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/view/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
		if(operation.equals("1")) {
			createOrder(request,response);
		}else if(operation.equals("2")) {
			findOrder(request,response);
			
		}else if(operation.equals("3")) {
			findOrderItem(request,response);
		}
			
		
		
	}

	/*
	 * ��jspҳ����ʾ����
	 * */
	
	
	//����
	private void findOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserOrder> orders = os.findOrder();
		request.setAttribute("orders", orders);
		request.getRequestDispatcher("ordershow.jsp").forward(request, response);
		
	}

	//������ϸ
	private void findOrderItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserOrderItem> items = os.findOrderItem();
		request.setAttribute("items", items);
		request.getRequestDispatcher("orderitem.jsp").forward(request, response);
		
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	OrderService os = new OrderServiceImpl();

	/*
	 * �¶���
	 * */
	public void createOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(os.createOrder()) {
			System.out.println("�µ��ɹ�");
			ProductServlet pServlet = new ProductServlet();
			//pServlet.jump(request, response);
			pServlet.findAll(request, response);
		}else {
			System.out.println("�µ�ʧ��");
		}

	}

	

}
