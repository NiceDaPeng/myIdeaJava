<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/28
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>登录页面</title>
  </head>
  <body>

  <form action="loginController" method="post" >

    ${requestScope.errorMessage}<br>
    账户:<input type="text" name="username" value=""> <br>
    密码:<input type="password" name="password" value=""> <br>
    <input type="submit" value="提交"> &emsp; &emsp; &emsp;
    <input type="reset" value="重置">
  </form>
  </body>
</html>
