<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 31.07.2019
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
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
<body id="registration" class="content">
<header class="container-fluid header">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-auto header__logo-wrap">
                <div class="header__logo">RTB inc.</div>
            </div>
            <div class="col-auto header__account-bar">
                <button class="text-button header__login">login</button>
                <button class="border-button header__register">Register</button>
            </div>
        </div>
    </div>
</header>
<main class="container-fluid registration">
    <form method="post" action="controller?action=backToMainPage">
        <button class="border-button back-button"><</button>
    </form>
    <jstl:if test="${not empty requestScope.notAdd}">
        <jstl:out value="${requestScope.notAdd}"/>
    </jstl:if>

    <jstl:if test="${not empty requestScope.notValidRegister}">
        <jstl:out value="${requestScope.notValidRegister}"/>
    </jstl:if>
    <div class="container">
        <div class="row">
            <div class="col">
                <h2 class="h2 registration__title">Register new account</h2>
                <form method="post" action="controller?action=register" class="registration__form">
                    <input type="text" name="name" id="" class="main-input registration__input" placeholder="First name">
                    <input type="text" name="surname" id="" class="main-input registration__input" placeholder="Second name">
                    <input type="text" name="email" id="" class="main-input registration__input" placeholder="Email">
                    <input type="text" name="password" id="" class="main-input registration__input" placeholder="password">
                    <input type="text" name="phone" id="" class="main-input registration__input" placeholder="phone (+380xx xxx xx xx)">
                    <input type="submit" value="Register" class="bg-button registration__button">
                </form>
            </div>
        </div>
    </div>
    <form method="post" action="controller?action=login" class="login-popup">
        <button class="align-self-end text-button login-popupexit">
            <img src="resources/img/exit-icon.svg" alt="" class="login-popupexit-img">
        </button>
        <input type="text" name="email" id="" class="main-input login-popupinput" placeholder="email">
        <input type="password" name="password" id="" class="main-input login-popupinput" placeholder="password">
        <jstl:if test="${not empty requestScope.wrongLoginOrPassword}">
            <div class="form-error login-popup__error">Wrong login or password</div>
        </jstl:if>
        <input type="submit" value="Sign in" class="bg-button login-popupbutton">
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