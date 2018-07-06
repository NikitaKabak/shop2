<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h2 style="text-align: center">Startpage</h2>
    <title>startpage</title>
    <jsp:include page="login.jsp"/>
</head>
<body>




<%--<form action="/authorization" method="post">login:<input name="userLastName">
    password<input name="userPassword">
    <input type="submit" name="nameButton" value="login"><br>
</form>--%>

<a href="/shop/catalog">Catalog</a>

<a href="/shop/registracion">registration</a><br>
<br>

</body>
</html>
