<%@page import="domain.UserSessionBinding"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");
//            HttpSession session = request.getSession();  //取得 HttpSession // 預設已有，不需要設變數
            session.setMaxInactiveInterval(120);   //設定其過期的時限為 2分鐘
            UserInfo user = UserInfo.getInstance();
            ArrayList list = user.getList();    //取得存放所有用戶的 Vector
            UserSessionBinding usb = new UserSessionBinding();
            usb.setUsername(username);
            user.addUser(username);   //加入至 list
            session.setAttribute("user", usb);   //此處發生 binding
//            session.invalidate();
        %>
    </body>
</html>