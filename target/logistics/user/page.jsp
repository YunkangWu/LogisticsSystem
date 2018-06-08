<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->

</head>

<body>
<div class="badoo">
    <span class="disabled">第${pageModel.page}页/共${pageModel.pageCount}页</span>
    <a href="${pageuri}&page=1">首页</a>
    <c:if test="${pageModel.page>1}">
        <a href="${pageuri}&page=${pageModel.prev}">上一页</a>
    </c:if>

    <c:forEach var="pre" items="${pageModel.prevPages }">
        <a href="${pageuri}&page=${pre }">${pre}</a>
    </c:forEach>
    <span class="current">${pageModel.page }</span>
    <c:forEach var="next" items="${pageModel.nextPages }">
        <a href="${pageuri}&page=${next }">${next}</a>
    </c:forEach>

    <c:if test="${pageModel.page<pageModel.last}">
        <a href="${pageuri}&page=${pageModel.next}">下一页</a>
    </c:if>
    <a href="${pageuri}&page=${pageModel.last}">尾页</a>
</div>
</body>
</html>
