<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
<form action="testParam1" method="post" >
   name: <input type="text" name="name"> <br>
    age: <input type="text" name="age"> <br>
    sex: <input type="text" name="sex"> <br>
    wallet-color<input type="text" name="wallet.color"/>
    wallet-money<input type="text" name="wallet.money"/>
    <input type="submit" value="测试"/> <br>
</form>

<form action="testParam1"></form>

<%--    <a href="index1.jsp">测试2</a>--%>

<%--<a href="test2">测试3</a>--%>
</body>
</html>
