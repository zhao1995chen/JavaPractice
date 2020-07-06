<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>display</title>
</head>
<body>
<!-- application 變數每個 user 進來都可以取用 -->
<p>Author: ${applicationScope.author}</p>
<p>Website: ${applicationScope.website}</p>
</body>
</html>