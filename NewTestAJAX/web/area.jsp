<%--
  Created by IntelliJ IDEA.
  User: DPJ
  Date: 2021/6/2
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select name="city" id="city">
    <c:forEach var="area" items="${requestScope.areas}">
        <option value="${area.aid}">${area.aname}</option>
    </c:forEach>
</select>

