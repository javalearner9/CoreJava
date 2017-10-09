package com.h2k.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println(" <HTML> <BODY> <h3> ");
		HttpSession session = req.getSession();
		
		if(session.isNew()){
			out.println("New Session - you may add some variable here");
		}
		
		session.setAttribute("ClientId", "4232394324897987");
		
		
		
		String attrValue = (String) session.getAttribute("ClientId");
		out.println("attrValue " + attrValue);
		
		out.println(" session.getCreationTime() :: " + session.getCreationTime());
		
		//session.setMaxInactiveInterval(5);
		
		int time = session.getMaxInactiveInterval();
		
		out.println(" session.getMaxInactiveInterval() :: " + session.getMaxInactiveInterval());
		

	
	}

}
