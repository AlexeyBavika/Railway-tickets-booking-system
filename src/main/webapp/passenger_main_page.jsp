<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 04.08.2019
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="controller?action=passengerGetRoutes">
    <p><input type="submit" value="routes"></p>
</form>

<form method="post" action="controller?action=sendBecomeAdminRequest">
    <p><input type="text" name="description" size="30"></p>
    <p><input type="submit" value="send request" size="30"></p>
</form>

<p>where you want to go ?</p>
<form method="post" action="controller?action=findRoute">
    <p>departure station</p>
    <p><input type="text" name="departureStation"></p>
    <p>destination station</p>
    <p><input type="text" name="destinationStation"></p>
    <p><input type="submit" value="find route"></p>
</form>

</body>
</html>
