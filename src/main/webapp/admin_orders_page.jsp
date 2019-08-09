<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 03.08.2019
  Time: 20:23
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
<form method="post" action="controller?action=adminBackToMainPage">
    <p><input type="submit" value="back"></p>
</form>
<h1>hello from admin orders page</h1>

<c:forEach items="${orders}" var="order">
    <tr>
        <td>
            <c:out value="${order.id}"/>
        </td>
        <td>
            <c:out value="${order.passengerId}"/>
        </td>
        <td>
            <c:out value="${order.trainId}"/>
        </td>
        <td>
            <c:out value="${order.placeType}"/>
        </td>
        <td>
            <c:out value="${order.price}"/>
        </td>
        <td>
            <form method="post" action="controller?action=deleteOrder">
                <input type="hidden" name="orderToDelete" value="${order.id}">
                <p><input type="submit" value="delete"></p>
            </form>
        </td>
    </tr>
</c:forEach>
</body>
</html>
