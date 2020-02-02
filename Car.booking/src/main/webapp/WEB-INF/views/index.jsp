<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("resources/images/index.jpg");
  background-color: #cccccc;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: Red;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
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
Total Items in Booking = ${totalcarditems} <a href="confirmorder">Confirm Booking</a> OR <a href="clearcart">Remove Booking</a>
<h2>Welcome</h2>
<h3 class="error"><c:if test="${param.message != null}">  <%= request.getParameter("message") %></c:if></h3>

<c:choose>
  <c:when  test="${not empty username}">
   welcome ${username} You can logout by clicking here <a href="<c:url value='/logout' />" >Log Out</a>
  </c:when>
  <c:otherwise>
    <h4>><a href="register">Sign Up</a></h2>
	<h4>><a href="login">Sign In</a></h2>
  </c:otherwise>
</c:choose>

<h2>Current Cars With Us</h2>

<div id="carscontainer">

<c:forEach var="element" items="${allcars}" >
      
        <div class="carcontainer">
          <h4 style="text-align:center;">${element.name}</h4>
	      <img src="<c:url value= '/uploads/${element.imageUrl}' />" width=260 height=195/></b>
	      <h4 style="text-align:center;">Price: Nepali Rupees-${element.price}</h4>
          <h4><a href="addtocard/?pid=${element.id}">Add To Booking</a></h4>
        </div>       
 </c:forEach>   
</div>
<div class="clear"></div>
</body>
</html>
