<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<body id="prices" class="content">
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
<main class="container-fluid prices">
    <div class="container">
        <form method="post" action="controller?action=adminBackToMainPage">
            <button class="border-button back-button"><</button>
        </form>
        <div class="row">
            <div class="col">
                <h2 class="h2 tours__title">Prices list and creation</h2>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <form method="post" action="controller?action=createPrice" class="prices__form">
                    <input type="text" name="routeId" id="" class="main-input prices__input prices__id-input" placeholder="route id">
                    <input type="text" name="berthPrice" id="" class="main-input prices__input" placeholder="berth price">
                    <input type="text" name="coupePrice" id="" class="main-input prices__input" placeholder="coupe price">
                    <input type="text" name="deluxePrice" id="" class="main-input prices__input" placeholder="deluxe price">
                    <input type="submit" value="Add price" class="bg-button prices__button">
                </form>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="main-list tours__list">
                    <li class="main-list__item main-list__headline tours__item">
                        <div class="main-list__col main-list__id">id</div>
                        <div class="main-list__col main-list__id">route id</div>
                        <div class="main-list__col main-list__price">berth</div>
                        <div class="main-list__col main-list__price">coupe</div>
                        <div class="main-list__col main-list__price">deluxe</div>
                    </li>
                    <jstl:forEach items="${prices}" var="price">
                        <li class="main-list__item tours__item">
                            <div class="main-list__col main-list__id"><jstl:out value="${price.id}"/></div>
                            <div class="main-list__col main-list__id"><jstl:out value="${price.routeId}"/></div>
                            <div class="main-list__col main-list__price"><jstl:out value="${price.berthPrice}"/></div>
                            <div class="main-list__col main-list__price"><jstl:out value="${price.coupePrice}"/></div>
                            <div class="main-list__col main-list__price"><jstl:out value="${price.deluxePrice}"/></div>
                            <form method="post" action="controller?action=deletePrice">
                                <input type="hidden" name="priceToDelete" value="${price.id}">
                                <button class="bg-button main-list__delete">delete</button>
                            </form>
                        </li>
                    </jstl:forEach>
                </ul>
            </div>
            <div class="col-12">
                <ul class="pagination prices__pagination">
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
            <small class="footer__copyright">&copy 2019 Alexey Bavyka<br>All rights reserved</small>
        </div>
    </div>
</footer>
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/main.js"></script>
</body>
</html>
