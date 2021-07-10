<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/4/29
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    private Integer id;
    private String name;
    private static Map<String,Object> map;

%>

<%!
    static {
        map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
    }
%>
<%!
    public void get(){
        System.out.println("hahaha");
    }
%>

<%!
    public static class InnerClass{

    }

    public class A{

    }
%>

<%=12 %> <br>
<%=12.12 %> <br>
<%="我是jsp输出脚本" %> <br>
<%=map %>
<%=request.getParameter("username")%>
<%
    String username = request.getParameter("username");
    System.out.println("用户请求的参数值是："+username);
%>
</body>
</html>
