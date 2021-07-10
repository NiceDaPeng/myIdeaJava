<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/21
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="jquery/jquery-3.6.0.js"></script>
<script type="text/javascript">
    $(function () {
        var $spanText = $("span").text;
        // alert($spanText);
    })
</script>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%
    //    String password = request.getParameter("password");
    String aname = (String) session.getAttribute("aname");
    String errorMessage = (String) request.getAttribute("errorMessage");
%>
欢迎登录ATM系统<%=aname%><br>
********************************* <br>
请选择操作项：<br>
<span><%=errorMessage%></span> <br>
<a href="query">查询</a> <br>
<a href="despot.jsp">存款</a> <br>
<a href="withDriawal.jsp">取款</a> <br>
<a href="transfer.jsp">转账</a> <br>
</body>
</html>
