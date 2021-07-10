<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>


<html>
<body>
    <h2>Hello World!</h2>

    <a href="testOne">测试环境</a>

    <form action="testUpload" method="post" enctype="multipart/form-data">
        <input type="text" name="text" value=""> <br>
        <input type="file" name="upload"> <br>
        <input type="submit" value="upload">
    </form>
    <br>

    <a href="downloadFile?fileName=lunbotu2.jpg">下载</a>
</body>
</html>
