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
<form method="post" action="controller?action=passengerBackToMainPage">
    <p><input type="submit" value="back"></p>
</form>

<h1>receipt</h1>
<p><c:out value="${sessionScope.trainId}"/></p>
<p><c:out value="${sessionScope.getName}"/></p>
<p><c:out value="${sessionScope.getSurname}"/></p>
<p><c:out value="${sessionScope.getEmail}"/></p>
<p><c:out value="${sessionScope.getPhone}"/></p>
<p><c:out value="${sessionScope.placeType}"/></p>
<p><c:out value="${sessionScope.placeNum}"/></p>
<p><c:out value="${sessionScope.price}"/></p>
<p><c:out value="${sessionScope.routeDepartureStation}"/></p>
<p><c:out value="${sessionScope.routeDepartureTime}"/></p>
<p><c:out value="${sessionScope.routeDestinationStation}"/></p>
<p><c:out value="${sessionScope.routeDestinationTime}"/></p>
<form method="post" action="passenger_orders_page.jsp">
    <p><input type="submit" value="print receipt"></p>
</form>

</body>
</html>
