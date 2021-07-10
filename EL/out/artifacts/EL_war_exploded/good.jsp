<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/26
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--假如我们在域对象中存入的是一个domain对象，我们想要获取对象中的属性值的话通过jsp提供的java标签方法--%>
<%--<%--%>
    <%--User user = (User) request.getAttribute("user");--%>
    <%--out.write(user.getName()); out.write("<br>");--%>
    <%--out.write(user.getPassword()); out.write("<br>");--%>
<%--%>--%>

<%--通过EL来取值的话如下方式：--%>
${requestScope.user.name} <br>
${requestScope.user.password}

${requestScope.userArray[0].name}
${requestScope.userArray[0].password}
</body>
</html>
