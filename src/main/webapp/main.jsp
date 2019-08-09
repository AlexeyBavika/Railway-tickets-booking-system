<%--
  Created by IntelliJ IDEA.
  User: Alexey
  Date: 31.07.2019
  Time: 23:27
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
    <h1><fmt:message key="main.greeting"/></h1>
    <p><a href="register.jsp"><fmt:message key="main.register"/></a></p>
    <p><a href="login.jsp"><fmt:message key="main.login"/></a></p>
</body>
</html>
