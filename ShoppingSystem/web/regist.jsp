<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/24
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
    <%--String errorMessage = (String) request.getAttribute("errorMessage");--%>
    <%--if (errorMessage != null){--%>
        <%--out.write(errorMessage);--%>
    <%--}--%>
<%--%>--%>

<c:if test="${requestScope.errorMessage != null}">
    ${errorMessage}
</c:if>
<form action="">
    账户：<input type="text" name="username" value="">
    密码：<input type="password" name="password" value="">
</form>
</body>
</html>
