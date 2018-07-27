package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.ProductServiceImplSql;
@WebServlet("/view/product")
public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2163516425576241675L;
	
	
	ProductService ps = new ProductServiceImplSql();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
			
		respose.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String operation = request.getParameter("operation");
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addProduct(request,respose);
				
			}else if(operation.equals("2")) {
				findAll(request,respose);
				
			}else if(operation.equals("3")) {
				updateProduct(request,respose);
				
			}else if(operation.equals("4")) {
				deleteProduct(request,respose);
				
			}else if(operation.equals("5")) {
				showProduct(request,respose);
			}else if(operation.equals("6")) {
				updateShow(request,respose);
			}	
				
			
		}
			
		
	}
	
	private void updateShow(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = findProductById(id);
			
		request.setAttribute("product", product);
		request.getRequestDispatcher("updateshow.jsp").forward(request, respose);
		
	}
	/*?????????*/
	private void showProduct(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = findProductById(id);
			
		request.setAttribute("product", product);
		request.getRequestDispatcher("showall.jsp").forward(request, respose);
		
	}
	/*??????*/
	public boolean deleteProduct(int id) {
		
		return ps.deleteProduct(id);
	}	
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		int id = 0;
		double price = 0.0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
					
			result = deleteProduct(id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("?????????");
		//	jump(request, respose);
			findAll(request, respose);
		}else {
			System.out.println("?????????");
		}
		
		
	}
	/*?????????*/
	public boolean updateProduct(Product product) {
		
		return ps.updateProduct(product);
	}
	private void updateProduct(HttpServletRequest request,HttpServletResponse respose) throws ServletException, IOException {
		int id = 0;
		double price = 0.0;
		int stock = 0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");
			price = Double.parseDouble(request.getParameter("price"));
			String image = request.getParameter("image");
			stock = Integer.parseInt(request.getParameter("stock"));
			
			Product product = findProductById(id);
			product.setName(name);
			product.setDetail(detail);
			product.setPrice(price);
			product.setImage(image);
			product.setStock(stock);
			result = updateProduct(product);
			
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("修改成功");
			//jump(request, respose);
			findAll(request, respose);
		}else {
			System.out.println("?????????");
		}
		
		
		
	}

	/*???????jsp???*/

	/*public void findAll(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		System.out.println("=================");
		List<Product> products = ps.findAll();
		request.setAttribute("products", products);
		request.getRequestDispatcher("product.jsp").forward(request, respose);
		
	}*/
	public void findAll(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
	
		ProductService ps = new ProductServiceImplSql();
		String pageNo = request.getParameter("pageNo");
		int _pageNo = 1;
		
		try {
			_pageNo= Integer.parseInt(pageNo);
			
		}catch(NumberFormatException e) {
			System.out.println("没有pageNo");
		}
		PageModel<Product> pageModel = ps.findProductByPage(_pageNo,  3);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("product.jsp").forward(request, respose);
		/*PrintWriter pw = respose.getWriter();
		String json = JSONArray.toJSONString(pageModel);
		System.out.println(json);
		pw.print(json)*/;
		
	
	}
	//??????
	/*public void jump(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		ProductService ps = new ProductServiceImplSql();
		PageModel<Product> pageModel = ps.findProductByPage(1, 3);
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("product.jsp").forward(request, respose);
	}*/
	
	
	
	/*
	 * ??????
	 * */
	private void addProduct(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		double price = 0.0;
		int stock = 0;
		boolean result = false;
		try {
			String name = request.getParameter("name");
			String detail = request.getParameter("detail");
			price = Double.parseDouble(request.getParameter("price"));
			String image = request.getParameter("image");
			stock = Integer.parseInt(request.getParameter("stock"));
			
			Product p = new Product(name,detail,price,image,stock);
			result = addProduct(p);
			findAll(request,respose);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("?????????");

			findAll(request, respose);
		}else {
			System.out.println("?????????");
		}
		
		
	}
	public boolean addProduct(Product product) {
		return ps.addProduct(product);
		
	}
	


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		doGet(req,resp);
	}
	
	
	
	
	//???ID
	public Product findProductById(int id) {
		
		return ps.findProductById(id);
	}
	
	
}
