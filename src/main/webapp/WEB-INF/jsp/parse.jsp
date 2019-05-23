<%--
  Created by IntelliJ IDEA.
  User: jackiechan
  Date: 10.04.19
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="parse-site/parseWebPage">
    <table>
        <tr>
            <td><label>Webpage</label></td>
            <td><input name="webpageName" type="text" maxlength="255"></input></td>
        </tr>
        <tr>
            <td><label>Tag</label></td>
            <td><input name="tag"type="text" maxlength="255" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
