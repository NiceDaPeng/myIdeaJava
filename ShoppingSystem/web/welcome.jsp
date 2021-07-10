<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/24
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        a{
            text-decoration: none;
            color: #ff4400;

        }
        a:hover {

            color: red;

        }
    </style>
</head>
<%--<%--%>
    <%--String uname = (String) session.getAttribute("uname");--%>
<%--%>--%>
<body>
    尊敬的${requestScope.uname}用户您好 <br>
    <%--登录成功选择购物--%>
    欢迎进入山寨购物系统 <br> 购物请点击<a href="categoryController">&gt;&gt;&gt;购物&lt;&lt;&lt;</a>

</body>
</html>
