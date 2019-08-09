<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 05.08.2019
  Time: 19:38
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
<c:if test="${not empty requestScope.routes}">
    <table>
        <c:forEach items="${routes}" var="route">
            <tr>
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
                    <form method="post" action="controller?action=chooseTrain">
                        <input type="hidden" name="id" value="${route.id}">
                        <p><input type="submit" value="choose train"></p>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${not empty requestScope.concreteRoutes}">
    <table>
        <c:forEach items="${concreteRoutes}" var="route">
            <tr>
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
                    <form method="post" action="controller?action=chooseTrain">
                        <input type="hidden" name="id" value="${route.id}">
                        <p><input type="submit" value="choose train"></p>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
