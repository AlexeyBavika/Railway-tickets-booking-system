<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
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
<body id="tours-pas" class="content">
<header class="container-fluid header">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-auto header__logo-wrap">
                <div class="header__logo">RTB inc.</div>
            </div>
            <div class="col-auto header__account-bar">
                <form method="post" action="controller?action=logout">
                    <button class="text-button header__login"><fmt:message key="logout"/></button>
                </form>
            </div>
        </div>
    </div>
</header>
<main class="container-fluid tours-pas">
    <div class="container">
        <form method="post" action="controller?action=passengerBackToMainPage">
            <button class="border-button back-button"><</button>
        </form>
        <div class="row">
            <div class="col">
                <h2 class="h2 tours__title"><fmt:message key="admin.routes.routesList"/></h2>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="main-list tours__list">
                    <li class="main-list__item main-list__headline tours__item">
                        <div class="main-list__col main-list__id"><fmt:message key="routes.id"/></div>
                        <div class="main-list__col main-list__station"><fmt:message
                                key="routes.departureStation"/></div>
                        <div class="main-list__col main-list__date"><fmt:message key="routes.departureTime"/></div>
                        <div class="main-list__col main-list__station"><fmt:message
                                key="routes.destinationStation"/></div>
                        <div class="main-list__col main-list__date"><fmt:message key="routes.destinationTime"/></div>
                    </li>
                    <jstl:if test="${empty requestScope.concreteRoutes}">
                        <jstl:forEach items="${routes}" var="route">
                            <li class="main-list__item tours__item">
                                <div class="main-list__col main-list__station"><jstl:out
                                        value="${route.departureStation}"/></div>
                                <div class="main-list__col main-list__date"><jstl:out value="${route.departureTime}"/></div>
                                <div class="main-list__col main-list__station"><jstl:out
                                        value="${route.destinationStation}"/></div>
                                <div class="main-list__col main-list__date"><jstl:out
                                        value="${route.destinationTime}"/></div>
                                <form method="post" action="controller?action=chooseTrain">
                                    <input type="hidden" name="id" value="${route.id}">
                                    <input type="hidden" name="routeDepartureStation" value="${route.departureStation}">
                                    <input type="hidden" name="routeDepartureTime" value="${route.departureTime}">
                                    <input type="hidden" name="routeDestinationStation" value="${route.destinationStation}">
                                    <input type="hidden" name="routeDestinationTime" value="${route.destinationTime}">
                                    <button class="bg-button main-list__delete"><fmt:message
                                            key="passenger.routes.chooseTrain"/></button>
                                </form>
                            </li>
                        </jstl:forEach>
                    </jstl:if>

                    <jstl:if test="${not empty requestScope.concreteRoutes}">
                        <jstl:forEach items="${concreteRoutes}" var="route">
                            <li class="main-list__item tours__item">
                                <div class="main-list__col main-list__station"><jstl:out
                                        value="${route.departureStation}"/></div>
                                <div class="main-list__col main-list__date"><jstl:out
                                        value="${route.departureTime}"/></div>
                                <div class="main-list__col main-list__station"><jstl:out
                                        value="${route.destinationStation}"/></div>
                                <div class="main-list__col main-list__date"><jstl:out
                                        value="${route.destinationTime}"/></div>
                                <form method="post" action="controller?action=chooseTrain">
                                    <input type="hidden" name="id" value="${route.id}">
                                    <input type="hidden" name="routeDepartureStation" value="${route.departureStation}">
                                    <input type="hidden" name="routeDepartureTime" value="${route.departureTime}">
                                    <input type="hidden" name="routeDestinationStation"
                                           value="${route.destinationStation}">
                                    <input type="hidden" name="routeDestinationTime" value="${route.destinationTime}">
                                    <button class="bg-button main-list__delete"><fmt:message
                                            key="passenger.routes.chooseTrain"/></button>
                                </form>
                            </li>
                        </jstl:forEach>
                    </jstl:if>
                    <li class="main-list__item main-list__popup main-list__headline">
                        <div class="main-list__col main-list__long-id main-list__popup-id main-list__popup-headline-id">
                            <fmt:message key="passenger.routes.berthPlace"/>
                        </div>
                        <div class="main-list__col main-list__short-price"><fmt:message key="orders.price"/></div>
                        <div class="main-list__col main-list__long-id main-list__popup-id main-list__popup-headline-id">
                            <fmt:message key="passenger.routes.coupePlace"/>
                        </div>
                        <div class="main-list__col main-list__short-price"><fmt:message key="orders.price"/></div>
                        <div class="main-list__col main-list__long-id main-list__popup-id main-list__popup-headline-id">
                            <fmt:message key="passenger.routes.deluxePlace"/>
                        </div>
                        <div class="main-list__col main-list__short-price"><fmt:message key="orders.price"/></div>
                    </li>
                    <jstl:forEach items="${trains}" var="train">
                        <li class="main-list__item main-list__popup main-list__popup-last">
                            <div class="main-list__col main-list__long-id main-list__popup-id"><jstl:out
                                    value="${train.berthNum}"/></div>
                            <div class="main-list__col main-list__short-price"><jstl:out
                                    value="${requestScope.berthPrice}"/></div>
                            <form method="post" action="controller?action=makeOrder">
                                <input type="hidden" name="trainId" value="${train.id}">
                                <input type="hidden" name="placeNum" value="${train.berthNum}">
                                <input type="hidden" name="placeType" value="berth"/>
                                <input type="hidden" name="price" value="${requestScope.berthPrice}">
                                <button class="bg-button main-list__popup-button"><fmt:message key="order"/></button>
                            </form>
                            <div class="main-list__col main-list__long-id main-list__popup-id"><jstl:out
                                    value="${train.coupeNum}"/></div>
                            <div class="main-list__col main-list__short-price"><jstl:out
                                    value="${requestScope.coupePrice}"/></div>
                            <form method="post" action="controller?action=makeOrder">
                                <input type="hidden" name="trainId" value="${train.id}">
                                <input type="hidden" name="placeNum" value="${train.coupeNum}">
                                <input type="hidden" name="placeType" value="coupe"/>
                                <input type="hidden" name="price" value="${requestScope.coupePrice}">
                                <button class="bg-button main-list__popup-button"><fmt:message key="order"/></button>
                            </form>
                            <div class="main-list__col main-list__long-id main-list__popup-id"><jstl:out
                                    value="${train.deluxeNum}"/></div>
                            <div class="main-list__col main-list__short-price"><jstl:out
                                    value="${requestScope.deluxePrice}"/></div>
                            <form method="post" action="controller?action=makeOrder">
                                <input type="hidden" name="trainId" value="${train.id}">
                                <input type="hidden" name="placeNum" value="${train.deluxeNum}">
                                <input type="hidden" name="placeType" value="deluxe"/>
                                <input type="hidden" name="price" value="${requestScope.deluxePrice}">
                                <button class="bg-button main-list__popup-button"><fmt:message key="order"/></button>
                            </form>
                        </li>
                    </jstl:forEach>
                </ul>
            </div>
            <div class="col-12">
                <ul class="pagination tours__pagination">
                    <li class="pagination__item">
                        <form method="post" action="controller?action=passengerGetRoutes">
                            <input type="hidden" name="page" value="1">
                            <button class="pagination__button">1</button>
                        </form>
                    </li>
                    <li class="pagination__item">
                        <form method="post" action="controller?action=passengerGetRoutes">
                            <input type="hidden" name="page" value="2">
                            <button class="pagination__button">2</button>
                        </form>
                    </li>
                    <li class="pagination__item">
                        <button class="pagination__button">3</button>
                    </li>
                    <li class="pagination__item">
                        <button class="pagination__button">4</button>
                    </li>
                    <li class="pagination__dots">...</li>
                    <li class="pagination__item">
                        <button class="pagination__button">10</button>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</main>
<footer class="container-fluid footer">
    <div class="container">
        <div class="row justify-content-center">
            <small class="footer__copyright">&copy 2019 Alexey Bavyka<br><fmt:message key="allRightsReserved"/></small>
        </div>
    </div>
</footer>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>
