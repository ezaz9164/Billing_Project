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
  
<form:form modelAttribute="customerDetailsForm">

  <h2>Customer Registration</h2>
		<p>
			<label for="CustomerName" class="floatLabel">Name</label>
			<form:input path="customerName"/>
				<form:errors path="customerName"></form:errors>
		</p>
		<p>
			<label for="customerGstNo" class="floatLabel">Gst No</label>
			<form:input path="customerGstNo" />
				<form:errors path="customerGstNo"></form:errors>
		
		</p>
		<p>
			<label for="customerPhoneNo" class="floatLabel">Phone No</label>
					<form:input path="customerPhoneNo" title="not avaliable" />
				<form:errors path="customerPhoneNo"></form:errors>
			
		</p>
  	<p>
			<label for="customerAddress" class="floatLabel">Address</label>
			<form:input path="customerAddress" />
				<form:errors path="customerAddress"></form:errors>
			
		</p>
		<p>
			<input type="submit" value="Save" >
		</p>
		<a href="${pageContext.request.contextPath}/index.jsp"><h3 style="font-style: italic;">Go To Home</h3></a>
		
	</form:form>


</body>

</html>
