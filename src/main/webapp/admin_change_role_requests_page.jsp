<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 10.08.2019
  Time: 20:20
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
<c:forEach items="${changeRoleRequests}" var="changeRoleRequest">
    <tr>
        <td>
            <c:out value="${changeRoleRequest.id}"/>
        </td>
        <td>
            <c:out value="${changeRoleRequest.passengerId}"/>
        </td>
        <td>
            <c:out value="${changeRoleRequest.text}"/>
        </td>
        <td>
            <form method="post" action="controller?action=updateUserRole">
                <input type="hidden" name="passengerId" value="${changeRoleRequest.passengerId}">
                <input type="hidden" name="passengerNewRoleId" value="2">
                <input type="submit" value="new role : 2">
            </form>
        </td>
        <td>
            <form method="post" action="controller?action=deleteChangeRoleRequest">
                <input type="hidden" name="changeRoleRequestToDelete" value="${changeRoleRequest.id}">
                <p><input type="submit" value="delete"></p>
            </form>
        </td>
    </tr>
</c:forEach>
</body>
</html>
