<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 12.08.2019
  Time: 16:17
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
<c:forEach items="${passengerOrders}" var="order">
    <tr>
        <td>
            <c:out value="${order.trainId}"/>
        </td>
        <td>
            <c:out value="${order.placeType}"/>
        </td>
        <td>
            <c:out value="${order.price}"/>
        </td>
    </tr>
</c:forEach>
</body>
</html>