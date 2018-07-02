<%--
  Created by IntelliJ IDEA.
  User: zhech
  Date: 01.07.2018
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>

<c:url value="/logout" var="logoutUrl" />

<!-- csrt for log out-->
<form action="${logoutUrl}" method="post" id="logoutForm">
</form>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} | <a
            href="javascript:formSubmit()"> Logout</a>
    </h2>
</c:if>


 <button type="submit" class="btn">Log out</button>
</body>
</html>
