<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<spring:url value="/resources/JS/js_productRegistration.js"
	var="productJS" />

<script src="${productJS}"></script>

<script type="text/javascript">
	function loadDoc() {
		return new XMLHttpRequest();
	}

	function checkProductName(str) {
		var xhttp = loadDoc();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var checkStatus = this.responseText;
				checkFunction(checkStatus);
			}
		};
		xhttp.open("GET",
				"${pageContext.request.contextPath}/product/checkProductName.htm?pName="
						+ str, true);
		xhttp.send();
	}

	function populateGst() {
		var shttp = loadDoc();
		var companyName = document.getElementById("pComp").value;
		console.log(companyName);
		shttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200)

				var gstList = this.responseText;
			dropGsts(gstList);

		};
		shttp.open("GET",
				"${pageContext.request.contextPath}/product/getAllGsts.htm?cName="
						+ companyName, true);
		shttp.send();

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
				<div style="color: red;font-style: italic;font-size: 16px">
				<form:errors path="productName" />
				</div>
			</div>
			<div>
				COMPANY NAME
				<form:select path="productCompany" id="pComp">
					<form:option value="">select</form:option>
					<c:forEach items="${companyList}" var="company">
						<form:option value="${company}">${company}</form:option>
					</c:forEach>
				</form:select>
				<div style="color: red;font-style: italic;">
				<form:errors path="productCompany" />
				</div>
			</div>

			<div>
				GST
				<form:select path="gst" id="gTag" onfocus="populateGst()">
					<form:option value="">select</form:option>
				</form:select>
				<div style="color: red;font-style: italic;">
				<form:errors path="gst" />
				</div>
			</div>


			<div>
				MRP
				<form:input path="mrp" />
				<div style="color: red;font-style: italic;">
				<form:errors path="mrp" />
				</div>
			</div>
			<div>
				RATE
				<form:input path="rate" />
				<div style="color: red;font-style: italic;">
				<form:errors path="rate" />
				</div>
			</div>
			<div>
				HSN CODE
				<form:input path="hsnCode" />
				<div style="color: red;font-style: italic;">
				<form:errors path="hsnCode" />
				</div>
			</div>
			<div>
				REFERENCE UNITS
				<form:input path="unitOfReference" />
				<div style="color: red;font-style: italic;">
				<form:errors path="unitOfReference" />
				</div>
			</div>
			<div>
				NO OF UNITS
				<form:input path="noOfUnits" />
				<div style="color: red;font-style: italic;">
				<form:errors path="noOfUnits" />
				</div>
			</div>
			<div>
				<center>
					<input type="submit" value="REGISTER">
				</center>
			</div>
		</form:form>
	</div>
</body>