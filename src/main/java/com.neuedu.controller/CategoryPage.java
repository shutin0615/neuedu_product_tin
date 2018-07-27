package com.neuedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.service.CategoryService;
import com.neuedu.service.ProductService;
import com.neuedu.service.impl.CateGoryServiceImpl;
import com.neuedu.service.impl.ProductServiceImplSql;

/**
 * Servlet implementation class CategoryPage
 */
@WebServlet("/view/CategoryPage")
public class CategoryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CategoryService cgs = new CateGoryServiceImpl();
		String pageNo = request.getParameter("pageNo");
		System.out.println(pageNo);
		PageModel<Category> pageModel = cgs.findCategoryByPage(Integer.parseInt(pageNo), 4);
		
		request.setAttribute("pageModel", pageModel);
		request.getRequestDispatcher("findCategory.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
