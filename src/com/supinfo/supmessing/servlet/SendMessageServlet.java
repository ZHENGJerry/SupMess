package com.supinfo.supmessing.servlet;

import java.io.IOException;
import java.sql.Timestamp;

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
 * Servlet implementation class SendMessageServlet
 */
@WebServlet(urlPatterns="/sendMessage")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String operation = req.getParameter("operation");
		if(operation.equals("anonymous"))
		{
			sendAnonyMess(req,resp);
		}
		if(operation.equals("receiver"))
		{
			sendToUser(req,resp);
		}
		
	}

	private void sendToUser(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		String message = req.getParameter("message");
		String receiver = req.getParameter("receiver");
		Message mess = new Message();
		mess.setMessage(message);
		mess.setSender((String)req.getSession().getAttribute("username"));
		mess.setReceiver(receiver);
		mess.setTs(new Timestamp(System.currentTimeMillis()));
		
		DaoFactory.getMessageDao(emf).sendMessage(mess);
		
		req.getRequestDispatcher("/getHistory?name="+receiver).forward(req, resp);
		
		
	}

	private void sendAnonyMess(HttpServletRequest req,
			HttpServletResponse resp) {
		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		String message = req.getParameter("message");
		Message mess = new Message();
		mess.setMessage(message);
		mess.setSender("anony");
		mess.setReceiver("admin");
		mess.setTs(new Timestamp(System.currentTimeMillis()));
		
		DaoFactory.getMessageDao(emf).sendMessage(mess);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
