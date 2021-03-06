<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/table_style.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/add_modify_delete.js"></script>

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">站内公告</a></li>
    </ul>
</div>

<div class="rightinfo">

    <div class="tools">

        <ul class="toolbar">
            <li onclick="window.location.href='${pageContext.request.contextPath}/admin/addStationInfo.jsp'"><span><img
                    src="${pageContext.request.contextPath}/resources/images/t01.png"/></span>添加
            </li>
            <li class="modify"><span><img src="${pageContext.request.contextPath}/resources/images/t02.png"/></span>修改
            </li>
            <li class="del"><span><img src="${pageContext.request.contextPath}/resources/images/t03.png"/></span>删除</li>
        </ul>
    </div>

    <table class="tablelist">

        <thead>
        <tr>
            <th><input type="checkbox"/></th>
            <th>编号</th>
            <th>公告标题</th>
            <th>公告内容</th>
            <th>发布时间</th>
            <th>来源</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${stationInfoList}" var="stationInfo">
            <tr>
                <td><input name="id" type="checkbox" value="${stationInfo.id}"/></td>
                <td>${stationInfo.id}</td>
                <td>${stationInfo.infoTitle}</td>
                <td>${stationInfo.infoContent}</td>
                <td><fmt:formatDate value="${stationInfo.infoTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                <td>${stationInfo.infoFrom}</td>
                <td><a href="${pageContext.request.contextPath}/stationInfo/edit?id=${stationInfo.id}"
                       class="tablelink">修改</a> <a
                        href="${pageContext.request.contextPath}/stationInfo/delete?id=${stationInfo.id}"
                        class="tablelink"> 删除</a></td>
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

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>

