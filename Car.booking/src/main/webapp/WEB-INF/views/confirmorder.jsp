<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<style>
#carscontainer {
	width:900px;
	margin:0 auto;
	border:1px solid;
}
.clear {
	clear:both;
}
.carcontainer {
	float:left;
	width:295px;
}
</style>
<title>Welcome</title>
<link href="<c:url value='/resources/css/mystyle.css' />" rel="stylesheet" type="text/css">
</head>
<body>
<img src="<c:url value='/resources/images/logo.png' />" />
<a href="clearcart">Clear Booking</a>
<h2>Hello! ${username} Please confirm your Booking</h2>
<h3 class="error"><c:if test="${param.message != null}">  <%= request.getParameter("message") %></c:if></h3>


<h2>Your Selected Cars</h2>

<div id="carscontainer">
<sf:form method="POST" modelAttribute="allorders" commandName="allorders">
<table>
<tr><th>SN</th><th>Name</th><th>Image</th><th>Select Quantity</th></tr>
<c:forEach var="element" items="${allorders.orderCars}" varStatus="theCount" >
      
      <tr>
      	<td>${theCount.index+1}</td>
        <td>${element.name}</td>
        <td><img src="<c:url value= '/uploads/${element.imageUrl}' />" width=260 height=195/></td>
        <td><sf:input path="orderCars[${theCount.index}].orderedQuantity" size="5" />
        <sf:input path="orderCars[${theCount.index}].id" type="hidden" /></td>
      </tr>      
 </c:forEach>   
</table>
<input type="submit"  />
</sf:form>
</div>
</body>
</html>
