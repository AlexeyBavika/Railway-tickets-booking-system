<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body id="admin" class="content">
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
<main class="container-fluid admin">
    <div class="container">
        <div class="row">
            <div class="col">
                <h2 class="h2 admin__title"><fmt:message key="admin.WelcomeToAdminPage"/></h2>
            </div>
            <div class="col-12">
                <form method="post" action="controller?action=getAllUsers">
                    <input type="hidden" name="page" value="1">
                    <button class="bg-button admin__button"><fmt:message key="admin.users"/></button>
                </form>
                <form method="post" action="controller?action=getAllTrains">
                    <input type="hidden" name="page" value="1">
                    <button class="bg-button admin__button"><fmt:message key="admin.trains"/></button>
                </form>
                <form method="post" action="controller?action=getAllRoutes">
                    <input type="hidden" name="page" value="1">
                    <button class="bg-button admin__button"><fmt:message key="admin.routes"/></button>
                </form>
                <form method="post" action="controller?action=getAllPrices">
                    <input type="hidden" name="page" value="1">
                    <button class="bg-button admin__button"><fmt:message key="admin.prices"/></button>
                </form>
                <form method="post" action="controller?action=getAllOrders">
                    <input type="hidden" name="page" value="1">
                    <button class="bg-button admin__button"><fmt:message key="admin.orders"/></button>
                </form>
                <form method="post" action="controller?action=getAllChangeRoleRequests">
                    <input type="hidden" name="page" value="1">
                    <button class="bg-button admin__button"><fmt:message key="admin.changeRoleRequests"/></button>
                </form>
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
