<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:import url="header.jsp" />
<h3>Add new car</h3>
<h3 style="color:green"><c:if test="${param.message != null}">  <%= request.getParameter("message") %></c:if></h3>
<sf:form method="POST" modelAttribute="ca" enctype="multipart/form-data" commandName="ca">
		
			<table>
				
				<tr>
				<th>Car Name</th>
				<td><sf:input path="name" size="20"/>
				</br>
				<sf:errors path="name" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th>Car Manufacturer</th>
				<td><sf:input path="manufacturer" size="20"/>
				</br>
				<sf:errors path="manufacturer" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th>Price</th>
				<td><sf:input path="price" size="20"/>
				</br>
				<sf:errors path="price" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th>Stock</th>
				<td><sf:input path="stock" size="20"/>
				</br>
				<sf:errors path="stock" cssClass="error" />
				</td>
				</tr>
				
				<tr>
				<th>Brand</th>
				<td>
				<sf:select path="brandid" >
				<c:forEach var="element" items="${allbrans}" >
        			<sf:option value="${element.id}" label="${element.name}"/>
 				</c:forEach>     
                </sf:select>
                 
				</td>
				</tr>
				<tr>
				<th>Car Image</th>
				<td><sf:input path="imageFile" type="file"/>
				</br>
				<sf:errors path="imageFile" cssClass="error" />
				</td>
				</tr>
				<tr>
				<th></th>
				<td>
				<input type="submit" /></td>
				</tr>
		</table>
</sf:form>

</body>
</html>