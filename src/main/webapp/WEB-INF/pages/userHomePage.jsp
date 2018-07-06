<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 04.06.2018
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HomePageUsers</title>
    <jsp:include page="logout.jsp"/>

</head>

<c:set var="testUser" value="${TestUser}"></c:set>
<c:if test="${testUser != null}">
    <c:out value="User:"/><br>
    <c:out value="${testUser}"></c:out> // test Entity <br>
    <c:out value="${testUser.getUserRole().getRole()}"></c:out> // test EntityRole <br>
    <c:out value="${testUser.getUserStatus().getUserstatus()}"></c:out> // test EntityStatus <br>
</c:if>
<%--
<input id="Show" type="button" value="Показать"/>
<script>
    Show.onclick = function () {
        window.open("window.htm","win","height=300,width=300");
    }
</script>--%>
<%--OrderList--%>
<script type="text/javascript">
    function toggle_show(id) {
        document.getElementById(id).style.display = document.getElementById(id).style.display == 'none' ? 'block' : 'none';
    }
</script>
<c:set var="testOrderList" value="${TestOrderList}"></c:set>
<ul>
    <li onClick="toggle_show('OrderList')" >Показать список заказов
        <ul id="OrderList" style="display: none">
            <li>
                <c:if test="${testOrderList != null}">
                    <c:out value="TestOrderList:"/><br>
                    <c:forEach var="testOrderList" items="${testOrderList}">
                        <c:out value="${testOrderList}"></c:out> <br>
                        Order status:
                        <c:out value="${testOrderList.getOrgerStatus().getOrderstatus()}"></c:out> <br>
                        <br>
                    </c:forEach>
                </c:if>
            </li>

        </ul>
    </li>
</ul>
<a href="/shop/catalog">Catalog</a>

<body>
</body>
</html>
