<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 07.08.2019
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <c:forEach items="${admins}" var="admin">
        <tr>
            <td>
                <c:out value="${admin.id}"/>
            </td>
            <td>
                <c:out value="${admin.name}"/>
            </td>
            <td>
                <c:out value="${admin.surname}"/>
            </td>
            <td>
                <c:out value="${admin.email}"/>
            </td>
            <td>
                <c:out value="${admin.phone}"/>
            </td>
            <td>
                <form method="post" action="controller?action=deleteAdmin">
                    <input type="hidden" name="adminToDelete" value="${admin.id}">
                    <p><input type="submit" value="delete"></p>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
