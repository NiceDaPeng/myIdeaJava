<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/31
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 1){
      request.getRequestDispatcher("login").forward(request,response);
    }
  %>
  <form action="login" method="post">
    账户：<input type="text" name="username"> <br>
    密码：<input type="password" name="password"> <br>
    <input type="submit" name="submit" value="登录">
  </form>
  </body>
</html>
