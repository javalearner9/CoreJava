package com.h2k.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerImpl implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("ServletContextListenerImpl :: contextInitialized ");
		//ServletContext context = event.getServletContext();
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("ServletContextListenerImpl :: contextDestroyed ");

	}

	

}
