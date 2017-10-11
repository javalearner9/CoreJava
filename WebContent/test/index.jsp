<%@page import="java.util.Date"%>
<%@ page 
		language="java" 
		contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
    	buffer="32kb" 
    	autoFlush="true" 
    	errorPage="/test/error.jsp"
    	isErrorPage="false"
    	info="Additional Information about this Page"
	    isThreadSafe="true"
	    session="true"	 
	    isELIgnored="true" 
	     %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>First JSP</title>
</head>
<body>
<h1> You Actually Write HTML and Java Code here</h1>
</br>
<%! int i = 0;
	String firstName = "MyFirstName";
%>
<%-- This is JSP comment --%>
<!-- Scriplets - You can write Java Code within  -->
<% 
	out.println("Your IP Address is :: " + request.getRemoteAddr()); 
//	int error = 100/ 0;
%>
<p> 
	Today's date: <%= (new Date()).toLocaleString()%>
</p>

<!--  PageContext.PAGE_SCOPE - is a default scope is scope is not defined -->
<%
	
	pageContext.setAttribute("PageAttribute", "Acessible in this JSP Page", PageContext.PAGE_SCOPE);
	pageContext.setAttribute("requestAttribute", "Accessible within same request processing", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("ssessionAttribute", "Session", PageContext.SESSION_SCOPE);
	pageContext.setAttribute("applicationAttribute", "Application - ServletContext", PageContext.APPLICATION_SCOPE);
	
%>

<p> 
	requestAttribute with pageContext: <%= pageContext.getAttribute("requestAttribute", PageContext.REQUEST_SCOPE)%>
</p>

<%
	// response.sendRedirect("/TestSeptWeb/req");
	RequestDispatcher rd = application.getRequestDispatcher("/req");
	rd.forward(request, response);

%>


<%@ include file="/test/footer.jsp" %>
</body>
</html>