<%-- 
    Document   : default
    Created on : 2020/7/31, 上午 11:20:14
    Author     : Zhao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="admin/demo.jsp" method="post">
            帳號:<input type="text" name="user" value="John"/><br/>
            密碼:<input type="password" name="password" value="opensesame"/><br/>
            <input type="submit" value="登入"/>
        </form>
    </body>
</html>
