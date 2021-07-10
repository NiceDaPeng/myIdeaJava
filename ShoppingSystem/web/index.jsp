<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/24
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      window.onload=function () {
          var registBtn = document.getElementById("regist");
          registBtn.onclick=function () {
              window.location.href="regist.jsp";
          }
      }
    </script>
  </head>
  <style type="text/css">

  </style>
  <body>
  <%--<%--%>
    <%--String errorMessage = (String) request.getAttribute("errorMessage");--%>
    <%--if (errorMessage != null){--%>
        <%--out.write(errorMessage+"<br>");--%>
    <%--}--%>
  <%--%>--%>

  ${requestScope.errorMessage}
  
  <form action="userController" method="post">
    账户：<input type="text" name="uname" value=""> <br>
    密码：<input type="password" name="upassword" value=""> <br>
    <input type="submit" value="登录">&emsp;&emsp;
    <input id="regist" type="button" value="注册">
  </form>
  </body>
</html>
