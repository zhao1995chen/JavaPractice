<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
            <td><b>EL Expression</b></td>
            <td><b>Result</b></td>
        </thead>
        <tr>
            <td>\${1}</td>
            <td>${1}</td>
        </tr>
        <tr>
            <td>\${1 + 2}</td>
            <td>${1 + 2}</td>
        </tr>
        <tr>
            <td>\${1.2 + 2.3}</td>
            <td>${1.2 + 2.3}</td>
        </tr>
        <tr>
            <td>\${1.2E4 + 1.4}</td>
            <td>${1.2E4 + 1.4}</td>
        </tr>
        <tr>
            <td>\${-4 - 2}</td>
            <td>${-4 - 2}</td>
        </tr>
        <tr>
            <td>\${21 * 2}</td>
            <td>${21 * 2}</td>
        </tr>
        <tr>
            <td>\${3/4}</td>
            <td>${3/4}</td>
        </tr>
        <tr>
            <td>\${3 div 4}</td>
            <td>${3 div 4}</td>
        </tr>
        <tr>
            <td>\${3/0}</td>
            <td>${3/0}</td>
        </tr>
        <tr>
            <td>\${10%4}</td>
            <td>${10%4}</td>
        </tr>
        <tr>
            <td>\${10 mod 4}</td>
            <td>${10 mod 4}</td>
        </tr>
        <tr>
            <td>\${(1==2) ? 3 : 4}</td>
            <td>${(1==2) ? 3 : 4}</td>
        </tr>
    </table>
</body>
</html>
