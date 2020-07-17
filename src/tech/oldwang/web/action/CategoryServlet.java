package tech.oldwang.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.oldwang.domain.Category;
import tech.oldwang.service.CategoryService;
import tech.oldwang.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String methodName = request.getParameter("method");
		if("findAll".equals(methodName)) {
			// query all categories
			findAll(request, response);
		}else if("saveUI".equals(methodName)) {
			saveUI(request, response);
		}else if("save".equals(methodName)) {
			save(request, response);
		}else if("edit".equals(methodName)) {
			edit(request, response);
		}else if("update".equals(methodName)) {
			update(request, response);
		}else if("delete".equals(methodName)) {
			delete(request, response);
		}
	}
	/**
	 * Delete category
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer cid = Integer.parseInt(request.getParameter("cid"));
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.delete(cid);
		response.sendRedirect(request.getContextPath()+"/CategoryServlet?method=findAll");
	}
	/**
	 * update category
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cname = request.getParameter("cname");
		String cdesc = request.getParameter("cdesc");
		Integer cid = Integer.parseInt(request.getParameter("cid"));
		
		Category category = new Category();
		category.setCid(cid);
		category.setCname(cname);
		category.setCdesc(cdesc);
		
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.update(category);
		response.sendRedirect(request.getContextPath()+"/CategoryServlet?method=findAll");
		
		
	}

	/**
	 * Edit category
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer cid = Integer.parseInt(request.getParameter("cid"));
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = categoryService.findOne(cid);
		request.setAttribute("category", category);
		request.getRequestDispatcher("/admin/category_update.jsp").forward(request, response);
	}
	/**
	 * save category
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void save(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String cname = request.getParameter("cname");
		String cdesc = request.getParameter("cdesc");
		Category category = new Category();
		category.setCname(cname);
		category.setCdesc(cdesc);
		CategoryService categoryService = new CategoryServiceImpl();
		categoryService.save(category);
		response.sendRedirect(request.getContextPath()+"/CategoryServlet?method=findAll");
	}
	/**
	 * add category
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void saveUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/admin/category_add.jsp").forward(request, response);
		
	}

	/**
	 * Query all the categories
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters
		// encapsulate data
		// call service to process data
		CategoryService categoryService = new CategoryServiceImpl();
		List<Category> list = categoryService.findAll();
		// redirect
		request.setAttribute("list", list);
		request.getRequestDispatcher("/admin/category_list.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
