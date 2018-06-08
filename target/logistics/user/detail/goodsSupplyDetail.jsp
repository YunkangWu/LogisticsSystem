<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>货源信息详情</span></div>
    <ul class="forminfo">

        <li><label>始发地：</label><label>${goodsSupply.goodsStart}</label></li>
        <li><label>目的地:</label><label>${goodsSupply.goodsEnd}</label></li>
        <li><label>货物名:</label><label>${goodsSupply.goodsName}</label></li>
        <li><label>货量:</label><label>${goodsSupply.goodsQuantity}</label></li>
        <li><label>配货日期:</label><label><fmt:formatDate value="${goodsSupply.goodsTime}" pattern="yyyy-MM-dd"/></label>
        </li>
        <li><label>期望运价:</label><label>${goodsSupply.goodsPrice}</label></li>
        <li><label>期望车型:</label>
        <label><c:if test="${goodsSupply.goodsCarType == '1'}">半挂车</c:if>
            <c:if test="${goodsSupply.goodsCarType == '2'}">冷藏车</c:if>
            <c:if test="${goodsSupply.goodsCarType == '3'}">起重车</c:if>
            <c:if test="${goodsSupply.goodsCarType == '4'}">保温车</c:if>
        </label></li>
        <li><label>供应商:</label><label>${goodsSupply.goodsBelong.companyName}</label></li>
        <li><label>联系人:</label><label>${goodsSupply.goodsBelong.userName}</label></li>
        <li><label>联系电话:</label><label>${goodsSupply.goodsBelong.tellphone}</label></li>
        <li><label>发布时间:</label><label><fmt:formatDate value="${goodsSupply.createTime}"
                                                       pattern="yyyy-MM-dd HH:mm:ss"/></label></li>
    </ul>

</div>
</body>
</html>
