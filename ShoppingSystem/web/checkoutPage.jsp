<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Commodity" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/25
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        a{
            text-decoration: none;
        }
        a:hover{
            color: #ff4400;
        }

        table{
            width:60%;
            height: 60%;
            text-align: center;
        }
    </style>
</head>
<body>

<table border="1px" align="center" cellpadding="0px">
    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
    </tr>
    <%--<%--%>
        <%--ArrayList<Commodity> list = (ArrayList<Commodity>) session.getAttribute("commoList");--%>
        <%--Float sum = (Float) request.getAttribute("sum");--%>
        <%--for (Commodity commo :--%>
                <%--list) {--%>
            <%--out.write("<tr>");--%>
            <%--out.write("<td>"+commo.getCommName()+"</td>");--%>
            <%--out.write("<td>"+commo.getCommPrice()+"</td>");--%>
            <%--out.write("</tr>");--%>
        <%--}--%>
    <%--%>--%>

    <c:forEach var="commodity" items="${sessionScope.commoList}">
        <tr>
            <td>${commodity.commName}</td>
            <td>${commodity.commPrice}</td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="2">
            总价：${requestScope.sum}
        </td>
    </tr>
    <tr>
        <td><a href="#">支付宝付款</a></td>
        <td><a href="#">微信付款</a> </td>
    </tr>
</table>
</body>
</html>
