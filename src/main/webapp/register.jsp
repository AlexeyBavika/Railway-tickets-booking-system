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
    <title>Title</title>
</head>
<body>

<form method="post" action="controller?action=backToMainPage">
    <p><input type="submit" value="back"></p>
</form>

<jstl:if test="${not empty requestScope.notAdd}">
    <p>This user is exists</p>
</jstl:if>

<form method="post" action="controller?action=register">
    <p><input type="text" name="name" size="10"/> name</p>
    <p><input type="text" name="surname" size="10"/> surname</p>
    <p><input type="text" name="email" size="10" /> email</p>
    <p><input type="password" name="password" size="10" /> password</p>
    <p><input type="text" name="phone" size="10" /> phone</p>
    <p><input type="submit" value="register" /></p>
</form>

</body>
</html>
