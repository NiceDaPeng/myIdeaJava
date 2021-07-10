<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/21
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String aname = (String) session.getAttribute("aname");
        Float abalance = (Float) request.getAttribute("abalance");
    %>
    尊敬的<%=aname%>，您的余额为：<%=abalance%>
    <a href="login.jsp">返回</a>
</body>
</html>