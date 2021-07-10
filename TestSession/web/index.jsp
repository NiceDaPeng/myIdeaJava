<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/30
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Cookie cookie = new Cookie("test","testValue");
    cookie.setMaxAge(24*3600);
    response.addCookie(cookie);
  %>
  <a href="#">点我呀</a>
  </body>
</html>
