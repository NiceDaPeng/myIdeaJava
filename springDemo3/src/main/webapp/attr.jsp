<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/6/29
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>
<html>
<head>
    <title>attr</title>
</head>
<body>
    ${requestScope.name}
    ${sessionScope.user.name}====${sessionScope.user.age}

forward跳转的传递参数为对象形式的：${requestScope.user.name}=====${requestScope.user.age} <br>

redirect跳转的传递参数是个集合
    <c:forEach items="${sessionScope.users}" var="user">
        <h1> ${user.name}======${user.age}   </h1>
    </c:forEach>
</body>
</html>
