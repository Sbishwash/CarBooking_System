<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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


#toplinks {
	color:green;
	padding-left:20px;
	font-size:20px;
}
</style>
<meta charset="UTF-8">
<title>Admin page</title>
</head>
<body>

<h2>Admin Panel<a href="<c:url value='/logout' />" >Log Out</a></h2>

<a href="<c:url value='/admin/brands' />" id="toplinks">Brands</a>
<a href="<c:url value='/admin/cars' />" id="toplinks">Cars</a>
<a href="<c:url value='/admin/bookings' />" id="toplinks">Bookings</a>