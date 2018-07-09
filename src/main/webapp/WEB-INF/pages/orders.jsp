<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 09.07.2018
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${OrderList != null}">
    <c:out value="OrderList:"/><br>
    <c:forEach var="orderList" items="${OrderList}">
        <c:out value="${orderList}"></c:out> <br>
       <%-- <c:out value="${orderList.getListBasket()}"></c:out> <br>--%>
       <%-- <c:out value="${orderList.getUser()}"></c:out> <br>--%>
        <c:out value="${orderList.getOrgerStatus().getOrderstatus()}"></c:out> <br>
        <br>
    </c:forEach>
</c:if>
</body>
</html>
