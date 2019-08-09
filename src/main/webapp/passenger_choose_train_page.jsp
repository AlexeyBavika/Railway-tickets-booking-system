<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 07.08.2019
  Time: 17:39
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

<table>
    <c:forEach items="${trains}" var="train">
        <tr>
            <td>
                <c:out value="${train.berthNum}"/>
            </td>
            <td>
                <c:out value="${requestScope.berthPrice}"/>
            </td>
            <td>
                <form method="post" action="controller?action=makeOrder">
                    <input type="hidden" name="trainId" value="${train.id}">
                    <input type="hidden" name="placeNum" value="${train.berthNum}">
                    <input type="hidden" name="placeType" value="berth"/>
                    <input type="hidden" name="price" value="${requestScope.berthPrice}">
                    <p><input type="submit" value="order"></p>
                </form>
            </td>
            <td>
                <c:out value="${train.coupeNum}"/>
            </td>
            <td>
                <c:out value="${requestScope.coupePrice}"/>
            </td>
            <td>
                <form method="post" action="controller?action=makeOrder">
                    <input type="hidden" name="trainId" value="${train.id}">
                    <input type="hidden" name="placeNum" value="${train.coupeNum}">
                    <input type="hidden" name="placeType" value="coupe"/>
                    <input type="hidden" name="price" value="${requestScope.coupePrice}">
                    <p><input type="submit" value="order"></p>
                </form>
            </td>
            <td>
                <c:out value="${train.deluxeNum}"/>
            </td>
            <td>
                <c:out value="${requestScope.deluxePrice}"/>
            </td>
            <td>
                <form method="post" action="controller?action=makeOrder">
                    <input type="hidden" name="trainId" value="${train.id}">
                    <input type="hidden" name="placeNum" value="${train.deluxeNum}">
                    <input type="hidden" name="placeType" value="deluxe"/>
                    <input type="hidden" name="price" value="${requestScope.deluxePrice}">
                    <p><input type="submit" value="order"></p>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
