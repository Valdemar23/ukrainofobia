<%--
  Created by IntelliJ IDEA.
  User: jackiechan
  Date: 15.04.19
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="report/getReport">
<table>
    <tr>
        <td><p>Press this button if you want create PDF-report or return to main page:</p></td>
    </tr>
    <tr><td><a href="/">Return to main page</a></td></tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Get PDF-report"/>
        </td>
    </tr>
</table>
</form>
</body>
</html>
