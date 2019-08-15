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
<body id="users" class="content">
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
<main class="container-fluid users">
    <div class="container">
        <form method="post" action="controller?action=adminBackToMainPage">
            <button class="border-button back-button"><</button>
        </form>
        <div class="row">
            <div class="col">
                <h2 class="h2 users__title">Users list</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <jstl:if test="${not empty requestScope.cantDeleteUser}">
                    <jstl:out value="${requestScope.cantDeleteUser}"/>
                </jstl:if>
                <ul class="main-list users__list">
                    <li class="main-list__item main-list__headline users__item">
                        <div class="main-list__col main-list__id">id</div>
                        <div class="main-list__col main-list__name">name</div>
                        <div class="main-list__col main-list__surname">surname</div>
                        <div class="main-list__col main-list__email">email</div>
                        <div class="main-list__col main-list__phone">phone</div>
                        <div class="main-list__col main-list__phone">role id</div>
                    </li>
                    <jstl:forEach items="${users}" var="user">
                        <li class="main-list__item users__item">
                            <div class="main-list__col main-list__id"><jstl:out value="${user.id}"/></div>
                            <div class="main-list__col main-list__name"><jstl:out value="${user.name}"/></div>
                            <div class="main-list__col main-list__surname"><jstl:out value="${user.surname}"/></div>
                            <div class="main-list__col main-list__email"><jstl:out value="${user.email}"/></div>
                            <div class="main-list__col main-list__phone"><jstl:out value="${user.phone}"/></div>
                            <div class="main-list__col main-list__id"><jstl:out value="${user.roleId}"/></div>
                            <form method="post" action="controller?action=deleteUser">
                                <input type="hidden" name="userToDelete" value="${user.id}">
                                <input type="hidden" name="userToDeleteRoleId" value="${user.roleId}">
                                <button class="bg-button main-list__delete">delete</button>
                            </form>
                        </li>
                    </jstl:forEach>
                </ul>
            </div>
            <div class="col-12">
                <ul class="pagination users__pagination">
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