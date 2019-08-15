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
<body id="welcome" class="content">
<header class="container-fluid header">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-auto header__logo-wrap">
                <div class="header__logo">RTB inc.</div>
            </div>
            <div class="col-auto header__account-bar">
                <button class="text-button header__login">Login</button>
                <form method="post" action="register.jsp" class="header__register-form">
                    <button class="border-button header__register">Register</button>
                </form>
            </div>
        </div>
    </div>
</header>
<main class="container-fluid welcome">
    <div class="welcome__overlay"></div>
    <div class="container welcome__container">
        <div class="row justify-content-center">
            <div class="col-10">
                <h1 class="h1 welcome__title">Search for railway tickets</h1>
            </div>
            <div class="col-auto">
                <form method="post" action="register.jsp">
                    <button class="border-button welcome__register">Start you journey</button>
                </form>
            </div>
        </div>
    </div>
    <form method="post" action="controller?action=login" class="login-popup">
        <div class="align-self-end text-button login-popup__exit">
            <img src="resources/img/exit-icon.svg" alt="" class="login-popup__exit-img">
        </div>
        <input type="text" name="email" id="" class="main-input login-popup__input" placeholder="email">
        <input type="password" name="password" id="" class="main-input login-popup__input" placeholder="password">
        <jstl:if test="${not empty requestScope.wrongLoginOrPassword}">
            <div class="form-error login-popup__error">Wrong login or password</div>
        </jstl:if>
        <input type="submit" value="Sign in" class="bg-button login-popup__button">
    </form>
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
