<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 03.08.2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored ="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="controller?action=adminBackToMainPage">
    <p><input type="submit" value="back"></p>
</form>

<h1>hello from admin routes page</h1>

<form method="post" action="controller?action=createRoute">
    <p><input type="text" name="departureStation"> departure station</p>
    <p><input type="text" name="departureTime"> departure time</p>
    <p><input type="text" name="destinationStation"> destination station</p>
    <p><input type="text" name="destinationTime"> destination time</p>
    <p><input type="submit" value="create"></p>
</form>

<table>
    <tr>
        <th>
            <fmt:message key="user.id"/>
        </th>
        <th>
            <fmt:message key="user.name"/>
        </th>
        <th>
            <fmt:message key="user.surname"/>
        </th>
        <th>
            <fmt:message key="user.email"/>
        </th>
        <th>
            <fmt:message key="user.password"/>
        </th>
        <th>
            <fmt:message key="user.phone"/>
        </th>
        <th>
            <fmt:message key="user.roleId"/>
        </th>
    </tr>
    <c:forEach items="${routes}" var="route">
        <tr>
            <td>
                <c:out value="${route.id}"/>
            </td>
            <td>
                <c:out value="${route.departureStation}"/>
            </td>
            <td>
                <c:out value="${route.departureTime}"/>
            </td>
            <td>
                <c:out value="${route.destinationStation}"/>
            </td>
            <td>
                <c:out value="${route.destinationTime}"/>
            </td>
            <td>
                <form method="post" action="controller?action=deleteRoute">
                    <input type="hidden" name="routeToDelete" value="${route.id}">
                    <p><input type="submit" value="delete"></p>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
