<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display</title>
</head>
<body>
<% 
application.setAttribute("author", "Mary");
application.setAttribute("website", "www.mary.com");
%>
<a href="display.jsp">click</a>
</body>
</html>