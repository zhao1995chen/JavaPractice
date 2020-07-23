<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Database</title>
</head>
<body>
<sql:setDataSource var="sample" driver="com.mysql.cj.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/classicmodels?serverTimezone=CST"
	user="root" password="00000000" />
<sql:update dataSource="${sample}" var="result">
	create table if not exists Person (
		id int not null primary key,
		age int not null,
		firstname varchar(255),
		lastname varchar(255)
	)
</sql:update> 
<h1><c:out value="finish"/></h1>
</body>
</html>