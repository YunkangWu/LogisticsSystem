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
    <div class="formtitle"><span>仓储信息详情</span></div>
    <ul class="forminfo">

        <li><label>所在城市：</label><label>${storagesSupply.storagesCity}</label></li>
        <li><label>详细地址:</label><label>${storagesSupply.storagesLocation}</label></li>
        <li><label>仓储类型:</label>
            <label>
                <c:if test="${storagesSupply.storageType == '1'}">普通仓储</c:if>
                <c:if test="${storagesSupply.storageType == '2'}">冷藏仓储</c:if>
                <c:if test="${storagesSupply.storageType == '3'}">恒温仓储</c:if>
        </li>
        <li><label>仓储容量:</label><label>${storagesSupply.capacity}</label></li>
        <li><label>报价:</label><label>${storagesSupply.storagePrice}</label></li>
        <li><label>仓储公司:</label><label>${storagesSupply.storageBelong.companyName}</label></li>
        <li><label>联系人:</label><label>${storagesSupply.storageBelong.userName}</label></li>
        <li><label>联系电话:</label><label>${storagesSupply.storageBelong.tellphone}</label></li>
        <li><label>发布时间:</label><label><fmt:formatDate value="${storagesSupply.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></label></li>

    </ul>

</div>
</body>
</html>
