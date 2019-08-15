<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
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
<body id="requests" class="content">
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
<main class="container-fluid requests">
    <div class="container">
        <form method="post" action="controller?action=adminBackToMainPage">
            <button class="border-button back-button"><</button>
        </form>
        <div class="row">
            <div class="col">
                <h2 class="h2 orders__title">Requests list</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <ul class="main-list orders__list">
                    <li class="main-list__item main-list__headline tours__item">
                        <div class="main-list__col main-list__id">id</div>
                        <div class="main-list__col main-list__long-id">user id</div>
                        <div class="main-list__col main-list__message">message</div>
                    </li>
                    <jstl:forEach items="${changeRoleRequests}" var="changeRoleRequest">
                        <li class="main-list__item tours__item">
                            <div class="main-list__col main-list__id"><jstl:out value="${changeRoleRequest.id}"/></div>
                            <div class="main-list__col main-list__long-id"><jstl:out value="${changeRoleRequest.passengerId}"/></div>
                            <div class="main-list__col main-list__message"><jstl:out value="${changeRoleRequest.text}"/></div>
                            <form method="post" action="controller?action=updateUserRole">
                                <input type="hidden" name="passengerId" value="${changeRoleRequest.passengerId}">
                                <input type="hidden" name="passengerNewRoleId" value="2">
                                <button class="bg-button main-list__accept">accept</button>
                            </form>
                            <form method="post" action="controller?action=deleteChangeRoleRequest">
                                <input type="hidden" name="changeRoleRequestToDelete" value="${changeRoleRequest.id}">
                                <button class="bg-button main-list__delete">delete</button>
                            </form>
                        </li>
                    </jstl:forEach>
                </ul>
            </div>
            <div class="col-12">
                <ul class="pagination orders__pagination">
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


<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<c:forEach items="${changeRoleRequests}" var="changeRoleRequest">--%>
<%--    <tr>--%>
<%--        <td>--%>
<%--            <c:out value="${changeRoleRequest.id}"/>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <c:out value="${changeRoleRequest.passengerId}"/>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <c:out value="${changeRoleRequest.text}"/>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <form method="post" action="controller?action=updateUserRole">--%>
<%--                <input type="hidden" name="passengerId" value="${changeRoleRequest.passengerId}">--%>
<%--                <input type="hidden" name="passengerNewRoleId" value="2">--%>
<%--                <input type="submit" value="new role : 2">--%>
<%--            </form>--%>
<%--        </td>--%>
<%--        <td>--%>
<%--            <form method="post" action="controller?action=deleteChangeRoleRequest">--%>
<%--                <input type="hidden" name="changeRoleRequestToDelete" value="${changeRoleRequest.id}">--%>
<%--                <p><input type="submit" value="delete"></p>--%>
<%--            </form>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--</c:forEach>--%>
<%--</body>--%>
<%--</html>--%>
