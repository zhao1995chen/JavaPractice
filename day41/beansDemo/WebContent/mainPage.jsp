<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorDemo.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page Exception Handling</title>
</head>
<body>
	<%
		String s = "A";
		int v = Integer.parseInt(s);
		out.println(v);
	%>
</body>
</html>