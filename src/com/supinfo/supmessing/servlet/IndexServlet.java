package com.supinfo.supmessing.servlet;

import java.io.IOException;

import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supmessing.dao.DaoFactory;
import com.supinfo.supmessing.util.PersistenceManger;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(urlPatterns = "/index.html")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EntityManagerFactory emf = PersistenceManger.getEntityManagerFactory();
		Long userNum = DaoFactory.getUserDao(emf).getUserNum();
		Long messageNum = DaoFactory.getMessageDao(emf).getMessageNum();
		
		ServletContext sc = getServletContext();
		sc.setAttribute("usernum", userNum);
		sc.setAttribute("messagenum", messageNum);
		req.getRequestDispatcher("/updateHistory").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
