package com.h2k.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	
	@Override
	public void init() throws ServletException {
		System.out.println("This method will be called on Birth of HelloServlet -- Called only once");
	}
	
	/**
	 * Service - Servs for entire life of Servlet
	 * HTTP Methods / Requests - GET , POST, PUT, DELETE 
	 * According to request - service should be return 
	 * GET- doGet POST - doPost DELETE - doDelete
	 */
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println("For Entire Life - Hello Servlet will be calling doGet and doPost");
	
		// Sending information to Client Computer 
		Cookie cookie = new Cookie("WebSite", "Amazon.com");
		resp.addCookie(cookie);
		
		ServletContext context = getServletContext();
		context.setAttribute("FirstAttr" , "FirstAttr Value ");
		context.setAttribute("SecondAttr" , "SecondAttr Value ");
		
		context.removeAttribute("SecondAttr");
		context.setAttribute("FirstAttr", "Changed the Value"); 
		
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("Destroy Method called at the End of Servlet Life");
	}

	
}
