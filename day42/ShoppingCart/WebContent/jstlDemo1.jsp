<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="UTF-8"%>
<% // 加了 JSTL 的 plugins 後還需要加下面這一行才會 work %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<% // 原始寫法：在 JSP 裡寫 JAVA %>
		<% for(int i = 0; i < 10; i++) {%>
			<li>
				<%= i+1 %>
				<% if(i + 1 > 7) { %>
					greater than 7
				<% } %>
			</li>
		<% } %>
		
		<core:forEach var="i" begin="0" end="9">
			<li>
				<core:out value="${i + 1}"/>
				<core:if test="${i+1 > 7}">
					<core:out value="greater than 7"/>
				</core:if>
			</li>
		</core:forEach>
	</ul>
</body>
</html>