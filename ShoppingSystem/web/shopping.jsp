<%@ page import="java.util.List" %>
<%@ page import="domain.Category" %>
<%@ page contentType="text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Shopping</title>
    <script type="text/javascript">

        window.onload=function () {
            var cateSelect = document.getElementById("cate");
            cateSelect.onchange=function () {
                //在当前事件中this就是执行这个事件的对象。通过this.value来获取到种类的编号
                window.location.href="selectCommodityController?cateid="+this.value;
                // alert(this.value);
            }
        }

    </script>
</head>
<body>
请选择品类 <br>
<select name="cateSelect" id="cate">
    <option >==请选择==</option>
    <%--<%--%>
        <%--List<Category> list = (List<Category>) request.getAttribute("category");--%>
        <%--for (Category category--%>
                <%--:list) {--%>
            <%--out.write("<option value="+category.getCateId()+">"+category.getCateName()+"</option>");--%>
        <%--}--%>
    <%--%>--%>

    <c:forEach var="category" items="${requestScope.category}">
        <option value="${category.cateId}">${category.cateName}</option>
    </c:forEach>


</select>
</body>
</html>