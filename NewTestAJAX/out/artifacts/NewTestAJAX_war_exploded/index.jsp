<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/6/2
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index</title>
    <script type="text/javascript">
      window.onload=function () {

          document.getElementById("regist").onclick=function () {
              window.location.href="queryAllCountry";
          }
      }
    </script>
  </head>
  <body>

  <form action="login">
    账户：<input type="text" name="uname" value=""> <br>
    密码：<input type="password" name="password" value=""> <br>
    <input type="submit" value="登录">
    <input id="regist" type="button" value="注册">
  </form>
  </body>
</html>
