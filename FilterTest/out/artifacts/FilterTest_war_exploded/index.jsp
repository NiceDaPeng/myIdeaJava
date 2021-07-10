<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/28
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  ${requestScope.result}
  <form action="login" method="post">
    账户：<input type="text" name="username" value=""> <br>
    密码：<input type="password" name="password" value=""> <br>
    <input type="submit" value="登录">
  </form>
  </body>
</html>
