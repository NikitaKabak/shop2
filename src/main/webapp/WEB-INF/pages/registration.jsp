<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 22.04.2018
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</head>
<body>
<h2>Registration</h2>
<form method="post" action="/shop/registracion"> Name <input name ="name" >  <br>
    Password <input name="password" >  <br>
    Email <input name ="email" >  <br>
    <input type="submit" name="nameButton" value="Reg"><br>
</form>
</body>
</html>
