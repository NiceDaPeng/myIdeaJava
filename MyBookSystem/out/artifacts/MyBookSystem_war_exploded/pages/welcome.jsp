<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/28
  Time: 13:56
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
            color:#ff4400;
        }

        table{
            border:1px solid;
            text-align:center;
        }
    </style>
    <script type="text/javascript" href="jquery/jquery-3.6.0.js"></script>
    <script type="text/javascript">

        window.onload=function () {
            var aTag = document.getElementsByTagName("a");
            aTag.onclick = function () {
                window.location.href=""
            }
        }
    </script>
</head>
<body>
${sessionScope.uname}欢迎登录
<div>
    <table align="center">
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品描述</th>
            <th>执行操作</th>
        </tr>

            <c:forEach var="book" items="${sessionScope.booksList}">
                <tr>
                    <td>
                            ${book.bid}
                    </td>
                    <td>
                            ${book.bname}
                    </td>
                    <td>
                            ${book.bprice}
                    </td>
                    <td>
                            ${book.bdescription}
                    </td>
                    <td>
                        <a href="#">加入购物车</a>
                    </td>
                </tr>
            </c:forEach>

    </table>
</div>
</body>
</html>
