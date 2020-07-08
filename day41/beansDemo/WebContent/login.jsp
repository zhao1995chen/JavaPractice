<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<jsp:useBean id="myBean" class="beans.LoginBean">
		<jsp:setProperty name="myBean" property="*"/>
		<%-- property="*": 會自動尋找對應欄位的getter & setter，如果有多有少會有空白的狀況 --%>
	</jsp:useBean>
	Username: ${myBean.username}<br>
	Password: ${myBean.password}<br>
	Phone Number: ${myBean.phoneNumber}
</body>
</html>