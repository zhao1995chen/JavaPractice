<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.Test"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bean Test</title>
</head>
<body>
<% Test t = new Test(); %>
<%= t.msg() %>
<% // 不可加 ; %> 
<jsp:useBean id="t2" class="beans.Test"></jsp:useBean>
Message: ${t2.message}
</body>
</html>