<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
  <span>
      <form action="loginController" method="post">
        账户：<input type="text" name="username" value=""> <br>
        密码：<input type="password" name="password" value=""> <br>
        <input type="submit" name="submit" value="登录">
        <input type="reset" name="reset" value="重置">
      </form>
  </span>
</body>
</html>
