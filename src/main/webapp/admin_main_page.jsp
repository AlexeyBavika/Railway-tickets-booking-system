<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 31.07.2019
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="controller?action=logout">
    <p><input type="submit" value="logout"></p>
</form>

<h1>hello from admin page!</h1>

<form method="post" action="controller?action=getAllUsers">
    <p><input type="submit" value="users" size="30"></p>
</form>

<form method="post" action="controller?action=getAllTrains">
    <p><input type="submit" value="trains" size="30"></p>
</form>


<form method="post" action="controller?action=getAllRoutes">
    <p><input type="submit" value="routes" size="30"></p>
</form>

<form method="post" action="controller?action=getAllOrders">
    <p><input type="submit" value="orders" size="30"></p>
</form>

</body>
</html>
