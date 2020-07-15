<%@page import="model.SimpleEmployee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<%
		ArrayList<SimpleEmployee> list = new ArrayList<>();
		list = (ArrayList<SimpleEmployee>)session.getAttribute("emps");
		for(SimpleEmployee e: list) {
	%>
		<tr>
			<td><%= e.getId() %></td>
			<td><%= e.getFirstName() %></td>
			<td><%= e.getLastName() %></td>
			<td><%= e.getEmail() %></td>
		</tr>
	<% 	} %>
	</table>
</body>
</html>