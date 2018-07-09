<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 09.07.2018
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${ProductList != null}">
    <c:out value="ProductList:"/><br>
    <c:forEach var="productList" items="${ProductList}">
        <c:out value="${productList}"></c:out> <br>
        <c:out value="${productList.getProductstatus().getProductstatusName()}"></c:out> <br>
        <br>
    </c:forEach>
</c:if>
</body>
</html>
