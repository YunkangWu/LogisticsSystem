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
        <li><a href="#">货源信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <table class="tablelist">

        <thead>
        <tr>
            <th>编号</th>
            <th>始发地</th>
            <th>→</th>
            <th>目的地</th>
            <th>货物名</th>
            <th>货量</th>
            <th>信息状态</th>
            <th>发布日期</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${goodsSupplyList}" var="goodsSupply">
            <tr>
                <td>${goodsSupply.id}</td>
                <td>${goodsSupply.goodsStart}</td>
                <th>→</th>
                <td>${goodsSupply.goodsEnd}</td>
                <td>${goodsSupply.goodsName}</td>
                <td>${goodsSupply.goodsQuantity}</td>
                <td><c:if test="${goodsSupply.goodsStatus == '0'}">待交易</c:if>
                    <c:if test="${goodsSupply.goodsStatus == '1'}">交易完成</c:if></td>
                <td><fmt:formatDate value="${goodsSupply.goodsTime}" pattern="yyyy-MM-dd"/></td>

                <td><a href="${pageContext.request.contextPath}/goodsSupply/edit?id=${goodsSupply.id}"
                       class="tablelink">修改</a> <a
                        href="${pageContext.request.contextPath}/goodsSupply/delete?id=${goodsSupply.id}"
                        class="tablelink"> 删除</a>
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

