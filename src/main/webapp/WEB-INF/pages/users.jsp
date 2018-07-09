<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 09.07.2018
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <c:if test="${UserList != null}">
        <c:out value="UserList:"/><br>
        <c:forEach var="userList" items="${UserList}">
            <c:out value="${userList}"></c:out> <br>
            <c:out value="${userList.getUserRole().getRole()}"></c:out> <br>
            <c:out value="${userList.getUserStatus().getUserstatus()}"></c:out> <br>
            <br>
        </c:forEach>
    </c:if>
</head>


<body>

</body>
</html>
