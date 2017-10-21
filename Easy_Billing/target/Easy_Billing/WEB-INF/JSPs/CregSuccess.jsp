<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >

<head>
<spring:url value="/resources/css/style.css" var="cuscss"></spring:url>
 
<meta charset="UTF-8">
 
<title>Customer Registration</title>
<link rel="stylesheet" href="${cuscss}">

</head>


<body>
<form action="">
<h2>${subject} with Name:</h2>
<h2><font color="blue">${name}</font> </h2>
<h2>${operation} Successfully</h2>


<a href="${pageContext.request.contextPath}/${repeat}">${operation} Another ${subject}</a>
<a href="${pageContext.request.contextPath}/index.jsp">Go To Home</a>
</form>
</body>

</html>
