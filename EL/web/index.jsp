<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/26
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>EL</title>
  </head>
  <body>
  <%--&lt;%&ndash;原来我们取request域对象的值&ndash;%&gt;--%>
  <%--<%--%>
    <%--String str1 = (String) request.getAttribute("str");--%>
    <%--String str2 = (String) session.getAttribute("str");--%>
    <%--String str3 = (String) pageContext.getAttribute("str");--%>
    <%--String str4 = (String) application.getAttribute("str");--%>
  <%--%>--%>
  <%--&lt;%&ndash;通过EL--现在取域对象的值&ndash;%&gt;--%>
    <%--${requestScope.str1}--%>
    <%--${pageScope.str2}--%>
    <%--${applicationScope.str3}--%>
    <%--${sessionScope.str4}--%>

  <a href="testController">点我呀</a>
  </body>
</html>
