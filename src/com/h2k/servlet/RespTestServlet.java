package com.h2k.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RespTestServlet extends HttpServlet{
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		out.println(" <HTML> <BODY> <h3> ");
		
		Cookie cookie = new Cookie("Response", "Testing Response Cookiee");
		resp.addCookie(cookie);
		
		resp.addIntHeader("Refresh", 1);
		
		resp.setContentType("text/html");
		
		out.println("Date :: " + Calendar.getInstance().getTime());
		
		ServletContext context = getServletContext();
		
		ServletConfig config = getServletConfig();
		out.println(" </br> ");
		String param = config.getInitParameter("DBName");
		out.println("Read Init Param :: DBName " + param );
		
		Enumeration<String> initParams = config.getInitParameterNames();
		
		out.println(" </br> ");
		while(initParams.hasMoreElements()){
			param = initParams.nextElement();
			out.println("Read Init Param With Enumeration ::  " + param + " Value "  + config.getInitParameter(param) );
		}
		out.println(" </br> ");
		out.println(" config.getServletName() " + config.getServletName());
		
		
		//resp.sendRedirect("hello");
		
		out.println(" </h3> </BODY> </HTML>   ");
		
	
	}

}
