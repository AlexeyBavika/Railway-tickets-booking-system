<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jstl:if test="${not empty requestScope.notExists}">
    <p>This user not exists</p>
</jstl:if>

<form method="post" action="controller?action=login">
    <p><input type="email" name="email" size="10"/> enter email</p>
    <p><input type="password" name="password" size="10" /> enter password</p>
    <p><input type="submit" value="Login" /></p>
    <p></p>
</form>
</body>
</html>