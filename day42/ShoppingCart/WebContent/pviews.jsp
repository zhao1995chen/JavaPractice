<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%> 
</head>
<body>
	<ul>
		<core:forEach var="item" items="${products}">
			<li>
				<core:out value="${item.name}" />
				<core:out value="${item.price}" />
			</li>
		</core:forEach>
	</ul>
</body>
</html>