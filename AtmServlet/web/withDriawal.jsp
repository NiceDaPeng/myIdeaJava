<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/21
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>取款页面</title>
</head>
<body>
<%
    String aname = (String) session.getAttribute("aname");
%>
<form action="withDrawal">
    请输入您要取得金额：<input type="text" name="outMoney"> <br>
    <input type="submit" value="确定">
</form>
</body>
</html>
