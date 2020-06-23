<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>Number</th>
				<th>Number</th>
				<th>Result</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 1; i < 10; i++) {%>
				<%for(int j = 1; j < 10; j ++) {%>
					<tr>
						<td><%=i%></td>
						<td><%=j%></td>
						<td><%=i*j%></td>
					</tr>
				<%}%>
			<%}%>
		</tbody>
	</table>
</body>
</html>