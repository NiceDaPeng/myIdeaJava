<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/21
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
    <body>
        <%
            String aname = (String) session.getAttribute("aname");
        %>
        <form action="doDespot" method="get">
            请输入存款金额：<input type='text' name="inMoney" value=''>
            <br> <input type="submit" value="确定">
        </form>
    </body>
</html>
