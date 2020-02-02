<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value='/resources/css/mystyle.css' />" rel="stylesheet" type="text/css">
<title>Car Booking login</title>
</head>

<body>

<form role="form" action="j_spring_security_check" method="post">
                          <h3>  Login </h3>
                              
                              <input type="text" id="j_username" name="j_username"  placeholder="Username" required autofocus>
                              
                              <input type="password" id="j_password" name="j_password"  placeholder="Password" required>
                           
                             
                              <p style='color:red;'>${message}</p> 
                           
                          
                          <button type="submit" name="login">Sign in</button>
                        </form>


</body>
</html>