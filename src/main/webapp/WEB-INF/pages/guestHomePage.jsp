<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 28.06.2018
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>GuestHomePage</title>
    <jsp:include page="logout.jsp"/>
</head>
Hello Guest!!

<c:set var="testUser" value="${TestUser}"></c:set>
<c:if test="${testUser != null}">
    <c:out value="User:"/><br>
    <c:out value="${testUser}"></c:out> // test Entity <br>
    <c:out value="${testUser.getUserRole().getRole()}"></c:out> // test EntityRole <br>
    <c:out value="${testUser.getUserStatus().getUserstatus()}"></c:out> // test EntityStatus <br>
</c:if>

<body>

</body>
</html>
