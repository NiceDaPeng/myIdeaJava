<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Commodity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/25
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">

        window.onload=function () {
            //获取表单对象
            var formElement = document.getElementById("form");
            //通过class来获取button
            var buttonElement = document.getElementsByClassName("button");
            for (var i = 0; i < buttonElement.length; i++) {
                //给每个按钮绑定单击时间
                buttonElement[i].onclick=function () {
                    //获取隐藏域对象
                    var hiddenElement = document.getElementById("hidden");
                    //将每个按钮的值赋值给隐藏域的value 这样在控制层就可以通过点击不同的按钮来请求不同的转发。
                    hiddenElement.value = this.value;
                    //无论是哪个按钮被点击了都需要提交表单，所以要在循环内部
                    formElement.submit();
                }
            }

        }
    </script>
</head>
<body>
<form id="form" action="judgeChangeController" method="post">
    <input id="hidden" type="hidden" name="hidden" value="">
    <table align="center" border="1px" width="60%",height="60%">
        <tr>
            <th></th>
            <th>商品名称</th>
            <th>商品单价</th>
        </tr>
            <%--<%--%>
                <%--List<Commodity> list = (List)request.getAttribute("commdityList");--%>
                <%--for (Commodity commo: list--%>
                        <%--) {--%>
                    <%--out.write("<tr align='center'>");--%>
                    <%--out.write("<td><input type='checkbox' name='commCheck' value=\""+commo.getCommid()+"\"></td>");--%>
                    <%--out.write("<td>"+commo.getCommName()+"</td>");--%>
                    <%--out.write("<td>"+commo.getCommPrice()+"</td>");--%>
                    <%--out.write("</tr>");--%>
                <%--}--%>
            <%--%>--%>

            <c:forEach var="commo" items="${requestScope.commdityList}">

                <tr>
                    <td>
                        <input type="checkbox" name="commCheck" value="${commo.commid}">
                    </td>
                    <td>${commo.commName}</td>
                    <td>${commo.commPrice}</td>
                </tr>
            </c:forEach>


        <tr align="right">
            <td colspan="3">
                <input class="button" type="button" value="继续购物">
                    &nbsp;&nbsp;||&nbsp;&nbsp;
                <input class="button" type="button" value="商品结算">
            </td>
        </tr>

    </table>


</form>
</body>
</html>
