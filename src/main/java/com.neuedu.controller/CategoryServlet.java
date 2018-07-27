package com.neuedu.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.CategoryService;
import com.neuedu.service.impl.CateGoryServiceImpl;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/view/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");
			
		if(operation!=null&&!operation.equals("")) {
			if(operation.equals("1")) {
				addCategory(request,response);
				jump(request, response);
			}else if(operation.equals("2")) {
				findAll(request,response);
				
			}else if(operation.equals("3")) {
				updateCategory(request,response);
				jump(request, response);
			}else if(operation.equals("4")) {
				deleteCategory(request,response);
				jump(request, response);
			}else if(operation.equals("5")) {
				showCategory(request,response);
			}
		}
	}

	
	
	public void jump(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryService cgs = new CateGoryServiceImpl();
		
		PageModel<Category> pageModel = cgs.findCategoryByPage(1, 4);	
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("findCategory.jsp").forward(request, response);
		
		
	}
	

		//�޸�
	boolean updateCategory(Category category) {
		return cgs.updateCategory(category);
		
	}
	
	private void updateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int parent_id = Integer.parseInt(request.getParameter("parent_id"));
		
		String name = request.getParameter("name");
		int status = Integer.parseInt(request.getParameter("status"));
		int sort_order = Integer.parseInt(request.getParameter("sort_order"));
		
		
		Category category = findCategoryById(id);
		 category = new Category(id,parent_id,name,status,sort_order);
		boolean result = updateCategory(category);
		if(result) {
			System.out.println("�޸����ɹ�");
			
		}else {
			System.out.println("�޸����ʧ��");
		}
	}



		//����ID�鿴ĳ�����
	public Category findCategoryById(int id) {
			return cgs.findCategoryById(id);
			
	}
	private void showCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Category category =findCategoryById(id);
		
		request.setAttribute("category", category);
		request.getRequestDispatcher("updateCategory.jsp").forward(request, response);
		
	}



	//ɾ��
		boolean deleteCategory(int id) {
			return cgs.deleteCategory(id);
			
		}
		private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		double price = 0.0;
		boolean result = false;
		try {
			id = Integer.parseInt(request.getParameter("id"));
					
			result = deleteCategory(id);
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		if(result) {
			System.out.println("ɾ�����ɹ�");
			
			
		}else {
			System.out.println("ɾ�����ʧ��");
		}
		
	}



	/*�鿴���jspҳ��*/

	public void findAll(HttpServletRequest request, HttpServletResponse respose) throws ServletException, IOException {
		System.out.println("=================");
		List<Category> categorys = cgs.findAll();
		request.setAttribute("categorys", categorys);
		request.getRequestDispatcher("findCategory.jsp").forward(request, respose);
		
	}

	
	/*
	 * ������
	 * */
		boolean addCategory(Category category){
			return cgs.addCategory(category);
			
		}
		private void addCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			int parent_id = Integer.parseInt(request.getParameter("parent_id"));
			System.out.println(parent_id);
			String name = request.getParameter("name");
			int status = Integer.parseInt(request.getParameter("status"));
			int sort_order = Integer.parseInt(request.getParameter("sort_order"));
			
			
			
			Category category = new Category(parent_id,name,status,sort_order);
			boolean result = addCategory(category);
			if(result) {
				System.out.println("������ɹ�");
				
			}else {
				System.out.println("������ʧ��");
			}
		}
	

		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

	CategoryService cgs = new CateGoryServiceImpl();
	
	
	
	
	
}
