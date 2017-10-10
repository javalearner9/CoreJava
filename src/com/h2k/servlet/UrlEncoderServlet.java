package com.h2k.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UrlEncoderServlet extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		// Get the session object. Create a new one if it doesn't exist.
	    HttpSession session = req.getSession(true);

	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    out.println("<head><title> " + "SessionServlet Output " +
	                "</title></head><body>");
	    out.println("<h1> SessionServlet Output </h1>");
	    
	    // Set up a session hit counter. "sessionservlet.counter" is just the
	    // conventional way to create a key for the value to be stored in the
	    // session object "dictionary".
	    Integer ival = (Integer) session.getAttribute("sessionservlet.counter");
	    if (ival == null) {
	      ival = 1;
	    }
	    else {
	      ival = ival++;
	    }
	    // Save the counter value.
	    session.setAttribute("sessionservlet.counter", ival);
	    // Report the counter value. 
	    out.println(" You have hit this page <b>" + ival + "</b> times.<p>");
	    
	    // This statement provides a target that the user can click
	    // to activate URL rewriting. It is not done by default.
	    out.println("Click <a href=" + res.encodeURL("/TestSeptWeb/hello") +">here</a>");
	    out.println(" to ensure that session tracking is working even " +
	                "if cookies aren't supported.<br>");
	    out.println("Note that by default URL rewriting is not enabled" +
	                " due to its large overhead.");
	    
	 // Report data from request.
	    out.println("<h3>Request and Session Data</h3>");
	    out.println("Session ID in Request: " + req.getRequestedSessionId());
	    out.println("<br>Session ID in Request is from a Cookie: " + req.isRequestedSessionIdFromCookie());
	    out.println("<br>Session ID in Request is from the URL: " + req.isRequestedSessionIdFromURL());
	    out.println("<br>Valid Session ID: " +  req.isRequestedSessionIdValid());

	    // Report data from the session object.
	    out.println("<h3>Session Data</h3>");
	    out.println("New Session: " + session.isNew());
	    out.println("<br> Session ID: " + session.getId());
	    out.println("<br> Creation Time: " + new Date(session.getCreationTime()));
	    out.println("<br>Last Accessed Time: " + new Date(session.getLastAccessedTime()));
	    out.println("</body>");
	    out.close();
	}
}
