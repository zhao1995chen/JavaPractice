<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
<jsp:useBean id="products" scope="request" class="java.util.ArrayList" />
<table border="1" width="90%">
	<tr>
		<th>Code</th>
		<th>Price</th>
		<th>Description</th>
		<th>Quantity</th>
	</tr>
	<c:forEach var="p" items="${products}">
	<tr>
		<td>${p.code}</td>
		<td>${p.price}</td>
		<td>${p.description}</td>
		<td>${p.quantity}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>