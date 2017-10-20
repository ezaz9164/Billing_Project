
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script src="../JS/js_productRegistration.js"></script>


<script type="text/javascript" >


function loadDoc() {
	return new XMLHttpRequest();
}


function checkProductName(str) {
	var xhttp = loadDoc();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText);
			var checkStatus=this.responseText;
			checkFunction(checkStatus);
		}
	};
	xhttp.open("GET","${pageContext.request.contextPath}/product/checkProductName.htm?pName="+ str, true);
	xhttp.send();
}

</script>

</head>
<body>

	<div>
		<form:form modelAttribute="product">
			<div>
				PRODUCT NAME
				<form:input id="pId" path="productName"
					onblur="checkProductName(this.value)" />
				<span id="nError" style="color: red; font: normal;"></span>
			</div>
			<div>
				COMPANY NAME
				<form:select path="productCompany">
					<form:option value="">select</form:option>
					<c:forEach items="${companyDetailsList}" var="companyDetail">
						<form:option value="${companyDetail.companyName}">${companyDetail.companyName}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<div>
				GST (%)
				<form:select path="gst">
				
				
				<c:forEach items="${companyDetailsList}" var="companyDetail">
						<form:option value="${companyDetail.gst}">${companyDetail.gst}</form:option>
					</c:forEach>
				</form:select> 
			</div>
			<div>
				MRP
				<form:input path="mrp" />
			</div>
			<div>
				RATE
				<form:input path="rate" />
			</div>
			<div>
				HSN CODE
				<form:input path="hsnCode" />
			</div>
			<div>
				REFERENCE UNITS
				<form:input path="unitOfReference" />
			</div>
			<div>
				NO OF UNITS
				<form:input path="noOfUnits" />
			</div>
			<div>
				<center>
					<input type="submit" value="REGISTER">
				</center>
			</div>
		</form:form>
	</div>

</body>