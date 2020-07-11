<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="BIG5">
    <title>Fruit JSP</title>
</head>
<body>
<%
    HashMap<String, String> map = new HashMap<>();
    map.put("Apple", "美國");
    map.put("Mango", "台灣");
    map.put("Pipeapple", "泰國");
    String f = request.getParameter("fruit");
    String value = map.get(f);
%>
<h3>你選擇的水果 ${param.fruit} 產地是 <%= value %></h3>
</body>
</html>