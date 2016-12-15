package com.supinfo.supmessing.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessing.dao.DaoFactory;
import com.supinfo.supmessing.entity.Message;
import com.supinfo.supmessing.util.PersistenceManger;

/**
 * Servlet implementation class GetHistoryServlet
 */
@WebServlet("/getHistory")
public class GetHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp);
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		String recevier = req.getParameter("name");
		String currentname = (String) req.getSession().getAttribute("username");
		
		List<Message> historymessage = DaoFactory.getMessageDao(emf).getMessageHistory(currentname, recevier);
		
		
		req.setAttribute("history", historymessage);
		req.setAttribute("receiver", recevier);
		req.getRequestDispatcher("/auth/sendMessage.jsp").forward(req, resp);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp);
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
