<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp" />
<sf:form method="POST" modelAttribute="bran" commandName="bran">
			<table>
				
				<tr>
				<th>Add new Brand Name</th>
				<td><sf:input path="name" size="20"/>
				</br>
				<sf:errors path="name" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th></th>
				<td>
				<input type="submit" /></td>
				</tr>
		</table>
</sf:form>
<h3>Current brands Available</h3>
<c:forEach var="element" items="${allbrans}" >
      
	      NAME: <b>${element.name}</b></br>   
 </c:forEach>          


</body>
</html>