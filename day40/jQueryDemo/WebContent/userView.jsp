<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
    <p>Username:${sessionScope.username}</p>
    <p>Password:${sessionScope["password"]}</p>
</body>
</html>