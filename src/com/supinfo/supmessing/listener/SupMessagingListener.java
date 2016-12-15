package com.supinfo.supmessing.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.supinfo.supmessing.util.PersistenceManger;


@WebListener
public class SupMessagingListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		PersistenceManger.closeEntityManagerFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

	}

}
