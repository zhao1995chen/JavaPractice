<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application Counter</title>
</head>
<body>
<%
  Object data= application.getAttribute("count");
  if(data==null)
    application.setAttribute("count",1);
  else{
    int value=Integer.parseInt(data.toString());
    application.setAttribute("count",value+1);
  }
%>
Visit Count: ${ applicationScope.count }
</body>
</html>