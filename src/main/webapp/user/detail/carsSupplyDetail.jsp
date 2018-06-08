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
    <div class="formtitle"><span>车源信息详情</span></div>
    <ul class="forminfo">

        <li><label>始发地：</label><label>${carsSupply.carStart}</label></li>
        <li><label>目的地:</label><label>${carsSupply.carEnd}</label></li>
        <li><label>车型:</label>
        <label>
            <c:if test="${carsSupply.carType == '1'}">半挂车</c:if>
            <c:if test="${carsSupply.carType == '2'}">冷藏车</c:if>
            <c:if test="${carsSupply.carType == '3'}">起重车</c:if>
            <c:if test="${carsSupply.carType == '4'}">保温车</c:if></label></li>
        <li><label>载重:</label><label>${carsSupply.carCapacity}</label></li>
        <li><label>发车日期:</label><label><fmt:formatDate value="${carsSupply.carTime}" pattern="yyyy-MM-dd"/></label></li>
        <li><label>运价:</label><label>${carsSupply.carPrice}</label></li>
        <li><label>联系司机:</label><label>${carsSupply.carBelong.userName}</label></li>
        <li><label>联系电话:</label><label>${carsSupply.carBelong.tellphone}</label></li>
        <li><label>发布时间:</label><label><fmt:formatDate value="${carsSupply.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></label></li>
    </ul>
</div>
</body>
</html>
