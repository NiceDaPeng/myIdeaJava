<%@ page import="java.util.Properties" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>

<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/22
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    String header = request.getHeader("accept-Language");
    String[] split = header.split(",");
    String firstCheck = split[0].split(";")[0];
    Properties pro = new Properties();
    InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("font("+firstCheck+").properties");
    pro.load(new InputStreamReader(is));
    String account = pro.getProperty("Account");
    String password = pro.getProperty("password");
    String login = pro.getProperty("login");
    //还有一种方式：
//      InputStream resourceAsStream = this.getClass().getResourceAsStream("font(cn).properties");
//      pro.load(resourceAsStream);
%>
<form action="login">
    <%=account%>:<input type="text" name="" value="">
    <%=password%>:<input type="password" name="" value="">
    <input type="submit" value="<%=login%>">
</form>

<select name="language" id="language">
    <option value="en">英语</option>
    <option value="zh-CN">中文</option>
</select>
</body>
</html>
