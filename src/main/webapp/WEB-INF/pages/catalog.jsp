<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 22.04.2018
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Catalog</title>
</head>


<a href="/shop/basket">MyBacket</a>
<h2>Catalog</h2>
<c:forEach items="${catalog}" var="product">
    <c:out value = "(${product.getIdproduct()})"></c:out>
    <c:out value = "${product.getNameproduct()}"></c:out>
    <a href='product?idproduct=${product.getIdproduct()}'>${product.getNameproduct()}</a><br>
</c:forEach>
</body>
</html>
