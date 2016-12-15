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
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns="/login")
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
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		User user = DaoFactory.getUserDao(emf).findUser(User.class, username);
		System.out.println(user);
		if(user != null)
		{
			if(password.equals(user.getPassword()))
			{
				HttpSession session = req.getSession();
				session.setAttribute("username", username);
				req.getRequestDispatcher("/updateHistory").forward(req, resp);
			}
			else
			{
				req.setAttribute("usernamebefore", username);
				req.setAttribute("passwordwrong", "password error");
				req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("nousererror", "no user");
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		}
		
	}

}
