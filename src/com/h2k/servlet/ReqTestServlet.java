package com.h2k.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReqTestServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// How to get a Parameter from Request
		String param = req.getParameter("name");
		
		Enumeration<String> paramEnum = req.getParameterNames();
		
		String eachParam = null;
		PrintWriter out = resp.getWriter();
		out.println(" <HTML> <BODY> <h3> ");
		while(paramEnum.hasMoreElements()){
			eachParam = paramEnum.nextElement();
			out.println("Param Name " + eachParam + " Param Value :: " + req.getParameter(eachParam) );
			out.println(" </br> ");
			
		}
		
		out.println(" </br> ");
		// How do I see header information
		String eachHeader = null;
		Enumeration<String> headerNames = req.getHeaderNames();
		
		while(headerNames.hasMoreElements()){
			eachHeader = headerNames.nextElement();
			out.println("Header Name " + eachHeader + " Header Value :: " + req.getHeader(eachHeader) );
			out.println(" </br> ");
		}
		
		// How to get a Cookie
		out.println(" </br> ");
		Cookie[] cookies = req.getCookies();
		for(Cookie eachCookie : cookies){
			out.println("Cookie Name " + eachCookie.getName() + " Cookie Value :: " + eachCookie.getValue() );
			out.println(" </br> ");
		}
		
		// How to set and get attributes in request
		req.setAttribute("RequestAttrName0", "RequestAttrValue A");
		req.setAttribute("RequestAttrName1", "RequestAttrValue B");
		req.setAttribute("RequestAttrName2", "RequestAttrValue C");
		req.setAttribute("RequestAttrName3", "RequestAttrValue D");
		
		Enumeration<String> attributes = req.getAttributeNames();
		String eachAttr = null;
		out.println(" </br> ");
		while(attributes.hasMoreElements()){
			eachAttr = attributes.nextElement();
			out.println("Attribute Name :: " + eachAttr + " Attribute Value :: " + req.getAttribute(eachAttr) );
			out.println(" </br> ");
		}
		
		// Additional Information I get in Request
		/**
		 * req.getSession()
		 * 1. If session doesn't exists = it creates one
		 * 2. If it exists = it returns existing session
		 * 3. req.getSession(false) - will not create a session if session doesn't exists 
		 * returns session object if it exists
		 */
		
		HttpSession session = req.getSession(false); 
		if(session == null){
			out.println(" </br> ");
			out.println(" Session was not created" );
		}
		session = req.getSession(); 
		if(session != null){
			out.println(" </br> ");
			out.println(" Session is Now create" );
		}
		
		out.println(" </br> ");
		out.println(" req.getContentType()  :: " + req.getContentType() );
		out.println(" req.getContextPath()  :: " + req.getContextPath() );
		
		
		out.println(" </h3> </BODY> </HTML>   ");
	}

}
