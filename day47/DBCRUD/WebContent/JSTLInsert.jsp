<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Database Insert</title>
</head>
<body>
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=CST"
	user="root" password="00000000" />

<sql:update dataSource="${sample}" var="insert">
	insert into person(id, age, firstname, lastname) 
	values (105, 35, 'Amy', 'Smith'), (106, 28, 'Will', 'Smith')
</sql:update>

<sql:query dataSource="${sample}" var="result">
	select * from classicmodels.person
</sql:query>

<table border="1" width="60%">
	<tr>
		<th>Employee ID</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Age</th>
	</tr>
	<c:forEach var="row" items="${result.rows}">
		<tr>
			<td><c:out value="${row.id}" /></td>
			<td><c:out value="${row.firstname}" /></td>
			<td><c:out value="${row.lastname}" /></td>
			<td><c:out value="${row.age}" /></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>