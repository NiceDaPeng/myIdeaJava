<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/22
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>转账页面</title>
</head>
<body>
<%
    String aname = (String) session.getAttribute("aname");
%>
<form action="transfer">
    请输入对方账户：<input type="text" name="otherName"> <br>
    请输入转入金额：<input type="text" name="transferMoney"> <br>
    <input type="submit" value="确认转账">&nbsp;
    <input type="reset" value="重新输入">
</form>
</body>
</html>
