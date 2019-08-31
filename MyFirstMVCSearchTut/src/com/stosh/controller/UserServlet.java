package com.stosh.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.stosh.dao.UserDao;
import com.stosh.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			UserDao ud = new UserDao();
			
			if(request.getParameter("logIn")!=null) {
				User user = new User();
				user.setUserName(request.getParameter("userName"));
				user.setUserPassword(request.getParameter("userPassword"));
				
				User verifiedUser = ud.verifyUser(user);
				
				if(verifiedUser!=null) {
					
					HttpSession session = request.getSession();
					session.setAttribute("verifiedUser", verifiedUser);
					response.sendRedirect("home.jsp");
				}else {
					response.sendRedirect("login.jsp?in=invalidate");
				}
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
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
