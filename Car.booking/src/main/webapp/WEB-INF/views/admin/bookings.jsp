<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<c:import url="header.jsp" />
<h3>Current Bookings list</h3>
<table>
<tr><th>Bookings ID</th><th>car Name</th><th>Quantity</th><th>User</th><th>Bookings Date</th></tr>
<c:forEach var="element" items="${allbookings}" >
      <tr><td>${element.id}</td><td>${element.carname}</td><td>${element.quantity}</td><td>${element.username}</td><td>${element.date}</td></tr>
</c:forEach>         
</table>
</body>
</html>