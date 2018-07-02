<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 29.06.2018
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <c:set var="testUser" value="${TestUser}"></c:set>
    <c:if test="${testUser != null}">
        <c:out value="User:"/><br>
        <c:out value="${testUser}"></c:out> // test Entity <br>
        <c:out value="${testUser.getUserRole().getRole()}"></c:out> // test EntityRole <br>
        <c:out value="${testUser.getUserStatus().getUserstatus()}"></c:out> // test EntityStatus <br>
    </c:if>
</head>
<body>

</body>
</html>
