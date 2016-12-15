package com.supinfo.supmessing.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supmessing.dao.DaoFactory;
import com.supinfo.supmessing.entity.Friend;
import com.supinfo.supmessing.entity.User;
import com.supinfo.supmessing.util.PersistenceManger;

/**
 * Servlet implementation class FindContactServlet
 */
@WebServlet(urlPatterns = "/findFriend")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if(req.getParameter("operation").equals("list"))
		{
			listFriend(req,resp);
		}
		if(req.getParameter("operation").equals("find"))
		{
			findFriend(req,resp);
		}
		
		
	
	}

	private void findFriend(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		String targetUsername = req.getParameter("username");
		HttpSession session = req.getSession();
		String currentusername = (String) session.getAttribute("username");
		User u = DaoFactory.getUserDao(emf).findUser(User.class, targetUsername);
		
		if(u != null)
		{
			List<Friend> l = DaoFactory.getFriendDao(emf).testFriend(targetUsername, currentusername);
			if(!l.isEmpty())
			{
				req.setAttribute("alreadyfriend", "You already friends!!");
			}
			req.setAttribute("find", "Find the user, information as follow:");
			req.setAttribute("UserInformation", u);
			req.getRequestDispatcher("/jsp/findFriend.jsp").forward(req, resp);
		}
		else{
			req.setAttribute("notfind", "Not find the user!");
			req.getRequestDispatcher("/jsp/findFriend.jsp").forward(req, resp);
		}
	}

	private void listFriend(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		HttpSession session = req.getSession();
		String currentusername = (String) session.getAttribute("username");
		
		List<Friend> list = DaoFactory.getFriendDao(emf).listFriend(currentusername);
		
		req.setAttribute("listFriend", list);
		req.getRequestDispatcher("/auth/listFriend.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
