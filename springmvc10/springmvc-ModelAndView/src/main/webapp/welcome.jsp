<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/7/4
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

username:${requestScope.username}
session:${sessionScope.username}

<!%
%>
${requestScope.name == sessionScope.username}
<%="hello world"%>
<c:set >

</c:set>
</body>
</html>

