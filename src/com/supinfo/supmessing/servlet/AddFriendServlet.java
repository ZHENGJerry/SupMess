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
import com.supinfo.supmessing.entity.Friend;
import com.supinfo.supmessing.util.PersistenceManger;

/**
 * Servlet implementation class addContactServlet
 */
@WebServlet(urlPatterns = "/addFriend")
public class AddFriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddFriendServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		this.doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		String targetUsername = req.getParameter("username");
		HttpSession session = req.getSession();
		String currentusername = (String) session.getAttribute("username");
		if(currentusername.equals(targetUsername))
		{
			req.setAttribute("errorinformation", "Cant add yourself");
			req.getRequestDispatcher("/jsp/findFriend.jsp").forward(req, resp);
		}
		else
		{
				//create relation between two users.
			
				Friend r1 = new Friend();
				r1.setFirstuser(currentusername);
				r1.setSeconduser(targetUsername);
				DaoFactory.getFriendDao(emf).addFriend(r1);
				Friend r2 = new Friend();
				r2.setFirstuser(targetUsername);
				r2.setSeconduser(currentusername);
				DaoFactory.getFriendDao(emf).addFriend(r2);
				req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
	}

}
