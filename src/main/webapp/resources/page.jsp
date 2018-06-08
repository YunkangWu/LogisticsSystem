<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageuri}&page=1"><img
        src="${pageContext.request.contextPath}/resources/images/toleft_disabled.png" title="首页"></a>
<c:if test="${pageModel.page>1}">
    <a href="${pageuri}&page=${pageModel.prev}"><img
            src="${pageContext.request.contextPath}/resources/images/left_three.png" title="上一页"></a>
</c:if>
<c:if test="${pageModel.page<pageModel.last}">
    <a href="${pageuri}&page=${pageModel.next}"><img
            src="${pageContext.request.contextPath}/resources/images/right_three.png" title="下一页"></a>
</c:if>
<a href="${pageuri}&page=${pageModel.last}"><img
        src="${pageContext.request.contextPath}/resources/images/toright_disabled.png" title="尾页"></a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a class="black14_2">第${pageModel.page}页/共${pageModel.pageCount}页,共${pageModel.totalCount}条</a>
</body>
</html>
