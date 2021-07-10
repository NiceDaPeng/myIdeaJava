<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/27
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>文件上传</title>
  </head>
  <body>
  <form action="saveFileController" method="post" enctype="multipart/form-data">
    请输入名字：<input type="text" name="uname" value=""> <br>
    请选择文件：<input type="file" name="testFile" value=""> <br>
    请选择文件：<input type="file" name="testFile1" value=""> <br>
    请选择文件：<input type="file" name="testFile2" value=""> <br>
    请选择文件：<input type="file" name="testFile3" value=""> <br>
    <input type="submit" value="确定">
  </form>

  <%--<form action="saveFileControllerTwo" method="post" enctype="multipart/form-data">--%>
    <%--<input type="text" name="uname" value="">--%>
    <%--<input type="submit" value="提交"></input>--%>
  <%--</form>--%>
  </body>
</html>
