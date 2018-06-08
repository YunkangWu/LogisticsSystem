<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">发布信息</a></li>
        <li><a href="#">仓储信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>仓储信息</span></div>
    <form action="${pageContext.request.contextPath}/storagesSupply/add" method="post">
        <ul class="forminfo">
            <li><label>城市</label><input name="storagesCity" value="${requestScope.storagesSupply.storagesCity}" type="text"
                                          class="dfinput"/></li>
            <li><label>详细地址</label><input name="storagesLocation" value="${requestScope.storagesSupply.storagesLocation}" type="text"
                                          class="dfinput"/></li>
            <li><label>仓储类型</label>
                <select name="storageType" class="dfinput">
                    <option value="0"
                    ${requestScope.storagesSupply.storageType == '0'?'selected=\"selected\"':''}>---请选择期望车型---
                    </option>
                    <option value="1"
                    ${requestScope.storagesSupply.storageType == '1'?'selected=\"selected\"':''}>普通仓储
                    </option>
                    <option value="2"
                    ${requestScope.storagesSupply.storageType == '2'?'selected=\"selected\"':''}>冷藏仓储
                    </option>
                    <option value="3"
                    ${requestScope.storagesSupply.storageType == '3'?'selected=\"selected\"':''}>恒温仓储
                    </option>
                </select>
            </li>
            <li><label>仓储容量</label><input name="capacity" value="${requestScope.storagesSupply.capacity}" type="text"
                                          class="dfinput"/></li>
            <li><label>报价</label><input name="storagePrice" value="${requestScope.storagesSupply.storagePrice}" type="text"
                                          class="dfinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认发布"/></li>
        </ul>
    </form>

</div>


</body>

</html>
