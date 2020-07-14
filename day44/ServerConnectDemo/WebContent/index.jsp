<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee View</title>
</head>
<body>
	<%
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
	%>
	<table style="text-align: left; width: 80%;" border="1">
		<tr>
        	<td>員工編號</td><td>員工姓氏</td><td>員工名字</td><td>員工職稱</td>
        </tr>
		<c:forEach var="emp" items="${emps}">
		    <tr>
		        <td>${emp.employeeNumber}</td>
		        <td>${emp.firstName}</td>
		        <td>${emp.lastName}</td>
		        <td>${emp.jobTitle}</td>
		    </tr>
		</c:forEach>
	</table>
</body>
</html>