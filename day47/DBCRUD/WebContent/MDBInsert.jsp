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

<c:set var="id" value="${param['id']}" />
<c:set var="firstName" value="${param['firstName']}" />
<c:set var="lastName" value="${param.lastName}" />
<c:set var="age" value="${param.age}"></c:set>

<sql:update dataSource="${sample}" var="insert">
	insert into person(id, age, firstname, lastname)
	values (${id}, ${age}, '${firstName}', '${lastName}')
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
			<td><c:out value="${row.firstName}" /></td>
			<td><c:out value="${row.lastName}" /></td>
			<td><c:out value="${row.age}" /></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>