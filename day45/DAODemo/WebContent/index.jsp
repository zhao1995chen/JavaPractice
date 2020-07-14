<%@page import="model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List</title>
</head>
<body>
<jsp:useBean id="products" scope="request" class="java.util.ArrayList" />
<% Iterator itr = null; %>
<% itr = products.iterator(); %>
<table border="1" width="90%">
	<tr>
		<th>Code</th>
		<th>Price</th>
		<th>Description</th>
		<th>Quantity</th>
	</tr>
	<%
		while(itr.hasNext()) {
			Product p = (Product)itr.next();
	%>
	<tr>
		<td><%= p.getCode() %></td>
		<td><%= p.getPrice() %></td>
		<td><%= p.getDescription() %></td>
		<td><%= p.getQuantity() %></td>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>