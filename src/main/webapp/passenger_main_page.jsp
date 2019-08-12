<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 04.08.2019
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="controller?action=logout">
    <p><input type="submit" value="logout"></p>
</form>

<form method="post" action="controller?action=passengerGetRoutes">
    <p><input type="submit" value="routes"></p>
</form>

<c:if test="${empty requestScope.RoleChangeRequestSend}">
    <form method="post" action="controller?action=sendRoleChangeRequest">
        <input type="hidden" name="passengerId" value="${sessionScope.getId}">
        <p><input type="text" name="description" size="30"></p>
        <p><input type="submit" value="send request" size="30"></p>
    </form>
</c:if>


<form method="post" action="controller?action=passengerOrders">
    <p><input type="submit" value="my tickets"></p>
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
