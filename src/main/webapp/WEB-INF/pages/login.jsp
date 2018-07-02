<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 30.06.2018
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>

</head>

HELLO!


<body>

<c:url var="loginUrl" value="/authorization"/>
<form action="/authorization" method="POST">
    <table style="with: 50%">
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="userLastName" required="true"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="userPassword" required="true"/></td>
        </tr>
    </table>
    <input type="submit" value="Login"/>
</form>

</body>
</html>
