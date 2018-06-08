<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/search.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">会员中心</a></li>
        <li><a href="#">站内公告</a></li>
    </ul>
</div>

<div class="rightinfo">
    <table class="tablelist">

        <thead>
        <tr>
            <th>公告标题</th>
            <th>发布时间</th>
            <th>来源</th>
            <th>查看</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stationInfoList}" var="stationInfo">
            <tr>
                <td>${stationInfo.infoTitle}</td>
                <td><fmt:formatDate value="${stationInfo.infoTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${stationInfo.infoFrom}</td>
                <td><a href="${pageContext.request.contextPath}/stationInfo/show?id=${stationInfo.id}"
                       class="tablelink">公告详情</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>


    <div>
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
    </div>
</div>

<script>
    $(function () {
        $("#reset").click(function () {
            alert("重置")
        });
    });
</script>
</body>

</html>

