<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 03.08.2019
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored ="false" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="${bundle}"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="controller?action=adminBackToMainPage">
    <p><input type="submit" value="back"></p>
</form>
<h1>hello from admin users page !!</h1>

    <table>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>
                    <c:out value="${user.id}"/>
                </td>
                <td>
                    <c:out value="${user.name}"/>
                </td>
                <td>
                    <c:out value="${user.surname}"/>
                </td>
                <td>
                    <c:out value="${user.email}"/>
                </td>
                <td>
                    <c:out value="${user.password}"/>
                </td>
                <td>
                    <c:out value="${user.phone}"/>
                </td>
                <td>
                    <c:out value="${user.roleId}"/>
                </td>
                <td>
                    <form method="post" action="controller?action=deleteUser">
                        <input type="hidden" name="userToDelete" value="${user.id}">
                        <p><input type="submit" value="delete"></p>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
