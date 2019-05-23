
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Website: natad
  Date: 25.05.2016
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="attribute/html;charset=UTF-8" language="java" %>
<html>
<head>
    <name>Title</name>
    <script src="https://code.jquery.com/jquery-2.2.4.js"
            integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous">
    </script>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous"/>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
            integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous">
    </script>
    <link rel="stylesheet" href="/static/webpage-list.css"/>
    <link rel="stylesheet" href="/static/general.css"/>
</head>
<body class="container">
<div class="create-button">
    <button type="button" class="btn btn-primary col-xs-2" data-toggle="modal" data-target="#myModal">New webpage</button>
</div>
<p class="attribute-center attribute-success col-offset-xs-12 bg-success flash-message">${message}</p>

<table class="table table-striped attribute-center all-items">
    <tr>
        <th class="col-xs-2 attribute-center">Tag name</th>
        <th class="col-xs-3 attribute-center">Webpage</th>
        <th class="col-xs-1 attribute-center">Questions</th>
        <th class="col-xs-1 attribute-center">Edit</th>
        <th class="col-xs-1 attribute-center">Delete</th>
    </tr>
<%--<c:forEach items="${tags}" var="tag">
    <tr>
        <td>${tag.text}</td>
        <td>${tag.website.name}</td>
        <td>${webpage.tags.size()}</td>
        <td><a href="/tags/edit/${webpage.id}"><i class="glyphicon glyphicon-pencil" style="color: #d9b144;"></i></a></td>
        &lt;%&ndash;<td>
            <form action="/webpages/delete" method="post">
                <input type="hidden" name="id" value="${webpage.id}">
                <button type="submit" style="height: 0; border: 0; padding: 0;"><i class="glyphicon glyphicon-remove" style="color: #d90000;"></i></button>
            </form>
        </td>&ndash;%&gt;
    </tr>
</c:forEach>--%>
</table>
</body>
</html>
