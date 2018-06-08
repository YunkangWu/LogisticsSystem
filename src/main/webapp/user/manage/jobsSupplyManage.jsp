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
            <th>职位名称</th>
            <th>公司名称</th>
            <th>月薪（k）</th>
            <th>工作地点</th>
            <th>发布日期</th>
            <th>查看</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${jobsSupplyList}" var="jobsSupply">
            <tr>
                <td>${jobsSupply.jobTitle}</td>
                <td>${jobsSupply.companyName}</td>
                <td>${jobsSupply.salary}</td>
                <td>${jobsSupply.city}</td>
                <td><fmt:formatDate value="${jobsSupply.createTime}" pattern="yyyy-MM-dd"/></td>
                <td><a href="${pageContext.request.contextPath}/jobsSupply/edit?id=${jobsSupply.id}"
                       class="tablelink">修改</a> <a
                        href="${pageContext.request.contextPath}/jobsSupply/delete?id=${jobsSupply.id}"
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

