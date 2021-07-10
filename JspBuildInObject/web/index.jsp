<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/22
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String value="abc";

  %>
    <%--这是一个测试用的jsp页面--%>
    <%--<a href="#">这是一个测试链接</a>--%>
  <form action="regist" method="post">
  爱好
  <input type="checkbox" name="hoppy" value="抽烟">抽烟
  <input type="checkbox" name="hoppy" value="喝酒">喝酒
  <input type="checkbox" name="hoppy" value="烫头">烫头
    <input type="submit" value="提交">
  </form>

  <%
    StringBuffer url = request.getRequestURL();
    out.print(url);
    System.out.println(url);
    out.print("<br>");
    String uri = request.getRequestURI();
    out.print(uri);
    System.out.println(uri);
  %>
  </body>
</html>
