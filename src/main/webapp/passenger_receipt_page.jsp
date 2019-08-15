<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored ="false" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="Railway tickets">
    <title>Railway ticket booking site</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap-reboot.css">
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap-grid.css">
    <link rel="stylesheet" href="resources/css/main.css">
</head>
<body id="print" class="content">
<section class="container-fluid print">
    <div class="container">
        <div class="row">
            <div class="col">
                <h2 class="h2 print__title"><fmt:message key="passenger.receipt.check"/></h2>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <ul class="print__list">
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="users.name"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.getName}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="users.surname"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.getSurname}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="users.email"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.getEmail}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="users.phone"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.getPhone}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="trains.id"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.trainId}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="orders.placeType"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.placeType}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="passenger.receipt.placeNum"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.placeNum}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="orders.price"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.price}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="routes.departureStation"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.routeDepartureStation}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="routes.departureTime"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.routeDepartureTime}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="routes.destinationStation"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.routeDestinationStation}"/></div>
                    </li>
                    <li class="print__item">
                        <div class="print__col"><fmt:message key="routes.destinationTime"/></div>
                        <div class="print__col"><jstl:out value="${sessionScope.routeDestinationTime}"/></div>
                    </li>
                </ul>
                <form method="post" action="controller?action=passengerOrders">
                    <button class="bg-button main-list__popup-button"><fmt:message key="passenger.receipt.print"/></button>
                </form>
            </div>
        </div>
    </div>
</section>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>
