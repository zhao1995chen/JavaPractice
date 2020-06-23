<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Exercise</title>
</head>
<body>
<p>Your favorite animal is
<%=request.getParameter("myFavorite")%>!</p>
<p>Wow, mine is too!</p>
<p>Date: <%=new java.util.Date()%></p>
<p></p>
</body>
</html>