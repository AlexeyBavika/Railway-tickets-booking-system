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
<body id="trains" class="content">
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
<main class="container-fluid trains">
    <div class="container">
        <form method="post" action="controller?action=adminBackToMainPage">
            <button class="border-button back-button"><</button>
        </form>
        <div class="row">
            <div class="col">
                <h2 class="h2 tours__title"><fmt:message key="admin.trains.trainsList"/></h2>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form method="post" action="controller?action=createTrain" class="tours__form">
                    <p><input type="text" name="routeId" id="" class="main-input tours__input"> <fmt:message key="trains.routeId"/></p>
                    <p><input type="text" name="berthNum" id="" class="main-input tours__input"> <fmt:message key="trains.berthNum"/></p>
                    <p><input type="text" name="coupeNum" id="" class="main-input tours__input"> <fmt:message key="trains.coupeNum"/></p>
                    <p><input type="text" name="deluxeNum" id="" class="main-input tours__input"> <fmt:message key="trains.deluxeNum"/></p>
                    <button class="bg-button tours__button">
                        <fmt:message key="create"/>
                    </button>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="main-list tours__list">
                    <li class="main-list__item main-list__headline tours__item">
                        <div class="main-list__col main-list__id"><fmt:message key="trains.id"/></div>
                        <div class="main-list__col main-list__long-id"><fmt:message key="trains.routeId"/></div>
                        <div class="main-list__col main-list__long-id"><fmt:message key="trains.berthNum"/></div>
                        <div class="main-list__col main-list__long-id"><fmt:message key="trains.coupeNum"/></div>
                        <div class="main-list__col main-list__long-id"><fmt:message key="trains.deluxeNum"/></div>
                    </li>
                    <jstl:forEach items="${trains}" var="train">
                        <li class="main-list__item tours__item">
                            <div class="main-list__col main-list__id"><jstl:out value="${train.id}"/></div>
                            <div class="main-list__col main-list__long-id"><jstl:out value="${train.routeId}"/></div>
                            <div class="main-list__col main-list__long-id"><jstl:out value="${train.berthNum}"/></div>
                            <div class="main-list__col main-list__long-id"><jstl:out value="${train.coupeNum}"/></div>
                            <div class="main-list__col main-list__long-id"><jstl:out value="${train.deluxeNum}"/></div>
                                <form method="post" action="controller?action=deleteTrain">
                                    <input type="hidden" name="trainToDelete" value="${train.id}">
                                    <button class="bg-button main-list__delete"><fmt:message key="delete"/></button>
                                </form>
                        </li>
                    </jstl:forEach>
                </ul>
            </div>
            <div class="col-12">
                <ul class="pagination tours__pagination">
                    <li class="pagination__item"><button class="pagination__button">1</button></li>
                    <li class="pagination__item"><button class="pagination__button">2</button></li>
                    <li class="pagination__item"><button class="pagination__button">3</button></li>
                    <li class="pagination__item"><button class="pagination__button">4</button></li>
                    <li class="pagination__dots">...</li>
                    <li class="pagination__item"><button class="pagination__button">10</button></li>
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