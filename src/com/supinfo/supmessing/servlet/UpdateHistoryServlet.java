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
import com.supinfo.supmessing.entity.Message;
import com.supinfo.supmessing.util.PersistenceManger;

/**
 * Servlet implementation class RefreshHistoryServlet
 */
@WebServlet(urlPatterns="/updateHistory")
public class UpdateHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		
		
		List<Message> list = DaoFactory.getMessageDao(emf).getListMessageHistory((String)req.getSession().getAttribute("username"));
	
		HttpSession session = req.getSession();
		session.setAttribute("listHistory", list);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
