<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 28.06.2018
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AdminHomePage</title>
    <jsp:include page="logout.jsp"/>
</head>

<%--USER2--%>

<c:set var="testUser2" value="${TestUser2}"></c:set>
<c:if test="${testUser2 != null}">
    <c:out value="User2:"/><br>
    <c:out value="${testUser2}"></c:out> // test Entity <br>
    <c:out value="${testUser2.getUserRole().getRole()}"></c:out> // test EntityRole <br>
    <c:out value="${testUser2.getUserStatus().getUserstatus()}"></c:out> // test EntityStatus <br>
</c:if>
Hello Admin!!
<%--USER--%>

<c:set var="testUser" value="${TestUser}"></c:set>
<c:if test="${testUser != null}">
    <c:out value="User:"/><br>
    <c:out value="${testUser}"></c:out> // test Entity <br>
    <c:out value="${testUser.getUserRole().getRole()}"></c:out> // test EntityRole <br>
    <c:out value="${testUser.getUserStatus().getUserstatus()}"></c:out> // test EntityStatus <br>
</c:if>
<a href="/shop/catalog">Catalog</a>
<input id="ShowUsers" type="button" value="Показать Пользователей"/>
<script>
    ShowUsers.onclick = function () {
        window.open("/admin/showAllUsers");
    }
</script>
<input id="ShowProducts" type="button" value="Показать Товары"/>
<script>
    ShowProducts.onclick = function () {
        window.open("/admin/showAllProducts");
    }
</script>
<input id="ShowOrders" type="button" value="Показать Заказы"/>
<script>
    ShowOrders.onclick = function () {
        window.open("/admin/showAllOrders");
    }
</script>
<body>

</body>
</html>
