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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
		
		DaoFactory.getUserDao(emf).addUser(user);
		
		HttpSession session = req.getSession();
		session.setAttribute("username",username );
		req.getRequestDispatcher("/updateHistory").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
