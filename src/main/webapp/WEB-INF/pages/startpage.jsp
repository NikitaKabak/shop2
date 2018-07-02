<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>startpage</title>
</head>
<body>
<h2 style="text-align: center">Startpage</h2>
<form action="/authorization" method="post">login:<input name="name">
    password<input name="password">
    <input type="submit" name="nameButton" value="login"><br>
</form>

<a href="/shop/catalog">Catalog</a>

<a href="/shop/registracion">registration</a><br>
<br>

</body>
</html>
