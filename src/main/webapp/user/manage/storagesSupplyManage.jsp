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

</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">管理发布信息</a></li>
        <li><a href="#">仓储信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <table class="tablelist">
        <thead>
        <tr>
            <th>所在城市</th>
            <th>详细地址</th>
            <th>仓储容量</th>
            <th>仓储类型</th>
            <th>查看</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${storagesSupplyList}" var="storagesSupply">
            <tr>
                <td>${storagesSupply.storagesCity}</td>
                <td>${storagesSupply.storagesLocation}</td>
                <td>${storagesSupply.capacity}</td>
                <td><c:if test="${storagesSupply.storageType == '1'}">普通仓储</c:if>
                    <c:if test="${storagesSupply.storageType == '2'}">冷藏仓储</c:if>
                    <c:if test="${storagesSupply.storageType == '3'}">恒温仓储</c:if>
                </td>
                <td><a href="${pageContext.request.contextPath}/storagesSupply/edit?id=${storagesSupply.id}" class="tablelink">修改</a> <a
                        href="${pageContext.request.contextPath}/storagesSupply/delete?id=${storagesSupply.id}" class="tablelink"> 删除</a></td>
                </td>
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

