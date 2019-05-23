<%--
  Created by IntelliJ IDEA.
  User: jackiechan
  Date: 25.03.19
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Parse site</title>
</head>
<body>

<h1>Hello body</h1>
<a href="parse-site">Parse web-page</a><br><!--Це насправді посилання URL on controller (in this action WebPageController)-->
<a href="report">Get report from DB</a><br>
<%--<a href="users">This link don't work</a><br>--%>
<%--<form:form method="post" action="parseSite">
    <table>
        <tr>
            <td><form:label path="name">URL page:</form:label></td>//i think path relation with var in Developer
            <td><form:input path="name" /></td>//i think path relation with var in Developer
        </tr>
        <tr>
            <td><form:label path="tag">Tag</form:label></td>//i think path relation with var in Developer
            <td><form:input path="tag" /></td>//i think path relation with var in Developer
        </tr>
&lt;%&ndash;        <tr>
            <td><form:label path="specialty">Specialty</form:label></td>//i think path relation with var in Developer
            <td><form:input path="specialty" /></td>//i think path relation with var in Developer
        </tr>
        <tr>
            <td><form:label path="experience">experience</form:label></td>//i think path relation with var in Developer
            <td><form:input path="experience" /></td>//i think path relation with var in Developer
        </tr>
        <tr>&ndash;%&gt;
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>--%>
</body>
</html>