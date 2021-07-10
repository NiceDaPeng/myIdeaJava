<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/27
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="myFn" uri="http://dpjedu.com" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    这是我自己定义个JSTL函数，可以加计算两个整数的和 <br>
    函数的执行结果是：
    ${myFn: myFn(3, 4)} <br>

  </body>
</html>
