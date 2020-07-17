package tech.oldwang.web.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tech.oldwang.domain.User;
import tech.oldwang.service.UserService;
import tech.oldwang.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// accept parameters
		String methodName = request.getParameter("method");
		if("login".equals(methodName)) {
			login(request, response);
		}else if("logout".equals(methodName)) {
			logout(request, response);
		}
	}
	/**
	 * UserServlet login
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get username and password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + " " + password);
		// encapsulate data
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		// process data
		UserService userService = new UserServiceImpl();
		User existUser = userService.login(user);
		// redirection according to process result
		if (existUser == null) {
			// login fail
			// return login page
			request.setAttribute("msg", "wrong username or password!");
			request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
		}else {
			// login successful
			// save the user info, redirect
			request.getSession().setAttribute("existUser", existUser);
			response.sendRedirect(request.getContextPath()+"/admin/category_list.jsp");
		}
	}
	/**
	 * Log out
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 1. destroy session
		request.getSession().invalidate();
		// 2. Redirect to login page
		response.sendRedirect(request.getContextPath()+"/admin/login.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
