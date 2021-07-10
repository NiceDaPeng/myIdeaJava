<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/28
  Time: 8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="uploadController" method="post" enctype="multipart/form-data">
    账号<input type="text" name="username" value=""> <br>
    请选择文件：<input type="file" name="file" value=""> <br>
    <input type="submit" value="提交">
</form>
</body>
</html>
