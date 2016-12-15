package com.supinfo.supmessing.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supmessing.dao.DaoFactory;
import com.supinfo.supmessing.entity.User;
import com.supinfo.supmessing.util.PersistenceManger;

/**
 * Servlet implementation class UserInfomationServlet}
 */
@WebServlet("/information")
public class UserInfomationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UserInfomationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String operation = req.getParameter("operation");
		if(operation.equals("show"))
		{
			
			EntityManagerFactory emf  = PersistenceManger.getEntityManagerFactory();
			HttpSession session = req.getSession();
			User user = DaoFactory.getUserDao(emf).findUser(User.class, ((String)session.getAttribute("username")));
			req.setAttribute("userinformation", user);
			req.getRequestDispatcher("/auth/userInformation.jsp").forward(req, resp);
		}
		if(operation.equals("update"))
		{
			EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
			
			String username = req.getParameter("username");
			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setLastname(lastname);
			user.setFirstname(firstname);
			
			DaoFactory.getUserDao(emf).updateUser(user);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
