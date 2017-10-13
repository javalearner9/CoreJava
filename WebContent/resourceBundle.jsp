<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Access Variables from RB</title>
</head>
<body>

<fmt:setBundle basename="com.h2k.props.myVars" var="rbName"/>
<fmt:message key="var1" bundle="${rbName}"/>
<fmt:message key="var2" bundle="${rbName}"/>
<br/>


</body>
</html>