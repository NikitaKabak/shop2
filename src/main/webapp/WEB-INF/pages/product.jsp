<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 30.04.2018
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>

    <dl>
        <dt>ID</dt>
        <dd>${product.getIdproduct()}</dd>
        <dt>Name</dt>
        <dd>${product.getNameproduct()}</dd>
        <dt>Status</dt>
        <dd>${product.getIdcategory()}</dd>
        <dt>Price</dt>
        <dd>${product.getPrice()}</dd>
        <dt>Qantity</dt>
        <dd>${product.getQuantity()}</dd>
        <dt>ProductStatus</dt>
        <dd>${product.getProductstatus().getProductstatusName()}</dd>

            <%--<dt>Image</dt>
            <dd><img src="productImage?id=${product.id}" /></dd>--%>
    </dl>
    <form action="/shop/product" method="post">Введитете количество товара которое вы хотите приобрести <input name="byqantity">
        <input type="hidden" name="idProduct" value="${product.getIdproduct()}">
     <input type="submit" name="nameButton" value="addInBacket" ></form>

</body>
</html>
