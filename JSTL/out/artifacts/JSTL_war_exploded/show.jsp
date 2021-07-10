<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/5/26
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--格式化标签库--%>
<fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd HH：mm：ss"></fmt:formatDate>
value:需要被格式化的数据
pattern：格式化所遵循的格式
这个标签会直接显示这个格式化后的结果的



<%--${requestScope.user.uname} <br>--%>
<%--${requestScope.user.upassword}--%>

${requestScope.userList.get(0).uname}
${requestScope.userList.get(0).upassword}
<hr>
${requestScope.userList.get(1).uname}
${requestScope.userList.get(1).upassword}
<hr>
${requestScope.userList.get(2).uname}
${requestScope.userList.get(2).upassword}

<c:out value="dpj很帅">c:out的目的就是将标签的value打印出来，这个标签没啥用</c:out>

<c:if test="${requestScope.value > 10}">
    满足条件
</c:if>

<c:choose>
    <c:when test="">

    </c:when>
    <c:when test="">

    </c:when>
    <c:when test="">

    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>

<hr>

<c:forEach begin="1" end="5" step="1" varStatus="i">
    ${i.index} <br>
</c:forEach>

如果我们想要遍历一个集合正常的写法如下：
<c:forEach begin="0" end="${requestScope.userList.size()}" items="${requestScope.userList}" varStatus="i" var="user"></c:forEach>

平常我们写foreach循环
for（User user:userList){}
<c:forEach var="user" items="${requestScope.userList}">
    ${user.uname}--${user.upassword}
</c:forEach>
items：要遍历的集合
var：遍历出来的数据你用什么接收？
<hr>


<c:forTokens items="a-b-c-d-e-f" delims="-" var="value">
    ${value}
</c:forTokens>
把items中的数据 按照delims拆分 然后遍历items中的数据 给var
<hr>
<%--JSTL函数包--%>
${fn:contains(requestScope.strValue,"c")}
${fn:length(requestScope.userList.get(0).uname)}
${fn:replace(requestScope.strValue, "c", "abd")}


</body>
</html>
