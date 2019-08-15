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
<body id="registration" class="content">
<header class="container-fluid header">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-auto header__logo-wrap">
                <div class="header__logo">RTB inc.</div>
            </div>
            <div class="col-auto header__account-bar">
            </div>
        </div>
    </div>
</header>
<main class="container-fluid registration">
    <form method="post" action="controller?action=backToMainPage">
        <button class="border-button back-button"><</button>
    </form>
    <jstl:if test="${not empty requestScope.notAdd}">
        <fmt:message key="register.emailOrPhoneExists"/>
    </jstl:if>

    <jstl:if test="${not empty requestScope.notValidRegister}">
        <fmt:message key="register.youWroteSomethingWrong"/>
    </jstl:if>
    <div class="container">
        <div class="row">
            <div class="col">
                <h2 class="h2 registration__title"><fmt:message key="register.registerNewAccount"/></h2>
                <form method="post" action="controller?action=register" class="registration__form">
                    <input type="text" name="name" id="" class="main-input registration__input" placeholder="First name" required>
                    <input type="text" name="surname" id="" class="main-input registration__input" placeholder="Second name" required>
                    <input type="text" name="email" id="" class="main-input registration__input" placeholder="Email" required>
                    <input type="text" name="password" id="" class="main-input registration__input" placeholder="password" required>
                    <input type="text" name="phone" id="" class="main-input registration__input" placeholder="phone (+380xx xxx xx xx)" required>
                    <input type="submit" value="Register" class="bg-button registration__button">
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