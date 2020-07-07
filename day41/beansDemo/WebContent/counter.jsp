<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Counter</title>
</head>
<body>
	<jsp:useBean id="bean1" class="beans.Counter" scope="session"/>
	<% // <jsp:useBean> 必須先完成執行，後面 java 的指令才有辦法進行操作，否則會在sessionScope中找不到藥使用的變數，無法執行 %>
	<% bean1.setCounter(bean1.getCounter() + 1); %>
	The counter value is <jsp:getProperty name="bean1" property="counter"/>
</body>
</html>