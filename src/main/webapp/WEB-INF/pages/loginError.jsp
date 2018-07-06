
<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 26.04.2018
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>loginError</title>
</head>
<c:set var="error" value="${Error}"></c:set>
<c:out value="${error}"/>
<body>
<form action="/shop/login" method="post">login:<input name="name">
    password<input name="password">
    <input type="submit" name="nameButton" value="login"><br>
</form>
<a href="/shop/registracion">registration</a><br>

</body>
</html>
