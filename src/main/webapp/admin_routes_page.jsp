<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>
<html lang="en">
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
<body id="tours" class="content">
<header class="container-fluid header">
    <div class="container">
        <div class="row justify-content-between">
            <div class="col-auto header__logo-wrap">
                <div class="header__logo">RTB inc.</div>
            </div>
            <div class="col-auto header__account-bar">
                <button class="text-button header__login">logout</button>
            </div>
        </div>
    </div>
</header>
<main class="container-fluid tours">
    <div class="container">
        <form method="post" action="controller?action=adminBackToMainPage">
            <button class="border-button back-button"><</button>
        </form>
        <div class="row">
            <div class="col">
                <h2 class="h2 tours__title">Routes list and creation</h2>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form method="post" action="controller?action=createRoute" class="tours__form">
                    <input type="text" name="departureStation" id="" class="main-input tours__input"
                           placeholder="departure station">
                    <input type="text" name="departureTime" id="" class="main-input tours__input"
                           placeholder="departure time">
                    <input type="text" name="destinationStation" id="" class="main-input tours__input"
                           placeholder="destination station">
                    <input type="text" name="destinationTime" id="" class="main-input tours__input"
                           placeholder="destination time">
                    <input type="submit" value="Add route" class="bg-button tours__button">
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="main-list tours__list">
                    <li class="main-list__item main-list__headline tours__item">
                        <div class="main-list__col main-list__id">id</div>
                        <div class="main-list__col main-list__station">departure station</div>
                        <div class="main-list__col main-list__date">departure time</div>
                        <div class="main-list__col main-list__station">destination station</div>
                        <div class="main-list__col main-list__date">destination time</div>
                    </li>
                    <jstl:forEach items="${routes}" var="route">
                        <li class="main-list__item tours__item">
                            <div class="main-list__col main-list__id"><jstl:out value="${route.id}"/></div>
                            <div class="main-list__col main-list__station"><jstl:out value="${route.departureStation}"/></div>
                            <div class="main-list__col main-list__date"><jstl:out value="${route.departureTime}"/></div>
                            <div class="main-list__col main-list__station"><jstl:out value="${route.destinationStation}"/></div>
                            <div class="main-list__col main-list__date"><jstl:out value="${route.destinationTime}"/></div>
                            <form method="post" action="controller?action=deleteRoute">
                                <input type="hidden" name="routeToDelete" value="${route.id}">
                                <button class="bg-button main-list__delete">delete</button>
                            </form>
                        </li>
                    </jstl:forEach>
                </ul>
            </div>
            <div class="col-12">
                <ul class="pagination tours__pagination">
                    <li class="pagination__item">
                        <button class="pagination__button">1</button>
                    </li>
                    <li class="pagination__item">
                        <button class="pagination__button">2</button>
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
            <small class="footer__copyright">&copy 2019 Alexey Bavyka<br>All rights reserved</small>
        </div>
    </div>
</footer>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>