<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Using the Application Object</title>
</head>
<body>
	<h1>Using the Application Object</h1>
	<jsp:useBean id="bean1" class="beans.Counter" scope="session"></jsp:useBean>
	<jsp:useBean id="bean2" class="beans.Counter" scope="application"></jsp:useBean>
	<%
		bean1.setCounter(bean1.getCounter() + 1);
		bean2.setCounter(bean1.getCounter() + 1);
	%>
	You have visited this page  The counter value is: <jsp:getProperty  name="bean1"  property="counter"/> times.
    <br>
    This page has been visited by all users  The counter value is: <jsp:getProperty  name="bean2"  property="counter"/> times.

</body>
</html>