package com.bj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bj.entity.User;
import com.bj.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		System.out.println(userName + "----" + passWord);
		User user = new User(userName,passWord);
		UserService service = new UserService();
		
		boolean flag = service.login(user);
		System.out.println(flag+"=====LoginServlet");
		
		if(flag){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("main.jsp");
		}else{
			request.setAttribute("error", "用户名或密码错误");
			request.setAttribute("username", userName);
			request.setAttribute("password", passWord);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
}
