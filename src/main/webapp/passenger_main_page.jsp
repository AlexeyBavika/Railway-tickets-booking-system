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
<body id="main" class="content">
<header class="container-fluid header">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-auto header__logo-wrap">
                <div class="header__logo">RTB inc.</div>
            </div>
            <div class="col-auto header__account-bar">
                <button class="border-button header__callback">
                    <div class="header__callback-text"><fmt:message key="passenger.MainPage.getACollBack"/></div>
                    <div class="header__callback-phone"><jstl:out value="${sessionScope.getPhone}"/></div>
                </button>
                <form method="post" action="controller?action=logout">
                    <button class="text-button header__login"><fmt:message key="logout"/></button>
                </form>
            </div>
        </div>
    </div>
</header>
<main class="container-fluid main">
    <div class="container">
        <div class="row">
            <div class="col">
                <h1 class="h1 main__title"><fmt:message key="passenger.MainPage.welcomeToPassengerMainPage"/></h1>
            </div>
        </div>
        <div class="row justify-content-center align-items-start">
            <div class="col-6">
                <form method="post" action="controller?action=passengerGetRoutes">
                    <button class="main__routes-button"><fmt:message key="admin.routes"/></button>
                </form>
            </div>
            <div class="col-2">
                <form method="post" action="controller?action=passengerOrders">
                    <button class="main__tickets-button"><fmt:message key="passenger.MainPage.myTickets"/></button>
                </form>
            </div>
        </div>
        <div class="row justify-content-center">
            <form method="post" action="controller?action=findRoute">
                <div class="col-8 main__search">
                    <input type="text" name="departureStation" id="" class="main-input main__input"
                           placeholder="departure station">
                    <input type="text" name="destinationStation" id="" class="main-input main__input"
                           placeholder="destination station">
                </div>
                <div class="col-8">
                    <button class="bg-button main__search-button"><fmt:message key="search"/></button>
                </div>
            </form>
        </div>
        <div class="row justify-content-center">
            <jstl:if test="${empty requestScope.RoleChangeRequestSend}">
                <form method="post" action="controller?action=sendRoleChangeRequest">
                    <input type="hidden" name="passengerId" value="${sessionScope.getId}">
                    <div class="col-8">
                        <h2 class="h2 main__request-title"><fmt:message key="passenger.MainPage.applyForAdminRole"/></h2>
                    </div>
                    <div class="col-8">
                        <textarea name="description" id="" cols="30" rows="10" maxlength="300" resize="none"
                                  class="main__textarea"></textarea>
                    </div>
                    <div class="col-8">
                        <button class="bg-button main__request-button"><fmt:message key="passenger.MainPage.sendRequest"/></button>
                    </div>
                </form>
            </jstl:if>
        </div>
    </div>
</main>
<footer class="container-fluid footer">
    <div class="container">
        <div class="row justify-content-center">
            <small class="footer__copyright">&copy 2019 Alexey Bavyka<br><fmt:message key="allRightsReserved"/><small>
        </div>
    </div>
</footer>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>