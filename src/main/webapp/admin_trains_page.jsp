<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 03.08.2019
  Time: 20:08
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
<h1>hello from admin trains page</h1>



<form method="post" action="controller?action=deleteTrain">
    <p><input type="text" name="trainToDelete"> enter id of train to delete</p>
    <p><input type="submit" value="delete"></p>
</form>
<form method="post" action="controller?action=createTrain">
    <p><input type="text" name="routeId"> route id</p>
    <p><input type="text" name="berthNum"> berth num</p>
    <p><input type="text" name="coupeNum"> coupe num</p>
    <p><input type="text" name="deluxeNum"> deluxe num</p>
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
    <c:forEach items="${trains}" var="train">
        <tr>
            <td>
                <c:out value="${train.id}"/>
            </td>
            <td>
                <c:out value="${train.routeId}"/>
            </td>
            <td>
                <c:out value="${train.berthNum}"/>
            </td>
            <td>
                <c:out value="${train.coupeNum}"/>
            </td>
            <td>
                <c:out value="${train.deluxeNum}"/>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
