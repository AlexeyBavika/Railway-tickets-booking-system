<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 31.07.2019
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <button class="text-button header__login">logout</button>
                </form>
            </div>
        </div>
    </div>
</header>
<main class="container-fluid admin">
    <div class="container">
        <div class="row">
            <div class="col">
                <h2 class="h2 admin__title">Welcome to admin page</h2>
            </div>
            <div class="col-12">
                <form method="post" action="controller?action=getAllUsers">
                    <button class="bg-button admin__button">users</button>
                </form>
                <form method="post" action="controller?action=getAllTrains">
                    <button class="bg-button admin__button">trains</button>
                </form>
                <form method="post" action="controller?action=getAllRoutes">
                    <button class="bg-button admin__button">routes</button>
                </form>
                <form method="post" action="controller?action=getAllPrices">
                    <button class="bg-button admin__button">prices</button>
                </form>
                <form method="post" action="controller?action=getAllOrders">
                    <button class="bg-button admin__button">orders</button>
                </form>
                <form method="post" action="controller?action=getAllChangeRoleRequests">
                    <button class="bg-button admin__button">Change roles requests</button>
                </form>
            </div>
        </div>
    </div>
</main>
<footer class="container-fluid footer">
    <div class="container">
        <div class="row justify-content-center">
            <small class="footer__copyright">&copy 2019 Alexey Bavyka<br>All rights reserved</small>
        </div>
    </div>
</footer>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>
