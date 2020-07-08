<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Carts</title>
</head>
<body>
	<jsp:useBean id="cart" class="beans.MyBean" scope="session"></jsp:useBean>
	<jsp:setProperty property="*" name="cart"/>
	<%
		cart.processRequest(request);
	%>
	<p>You have the following items in your cart:</p>
	<ol>
		<%
			String[] items = cart.getItems();
			for(int i = 0; i < items.length; i++) {
		%>
		<li>
		<% 
				out.print(items[i]);
			}
		%>
		</li>
	</ol>
</body>
</html>