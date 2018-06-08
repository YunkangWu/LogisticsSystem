<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">发布信息</a></li>
        <li><a href="#">货源信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>货源信息</span></div>
    <form action="${pageContext.request.contextPath}/goodsSupply/add" method="post">
        <ul class="forminfo">
            <li><label>始发地</label><input name="goodsStart" value="${requestScope.goodsSupply.goodsStart}" type="text"
                                         class="dfinput"/></li>
            <li><label>目的地</label><input name="goodsEnd" value="${requestScope.goodsSupply.goodsEnd}" type="text"
                                         class="dfinput"/></li>
            <li><label>货物名</label><input name="goodsName" value="${requestScope.goodsSupply.goodsName}" type="text"
                                         class="dfinput"/></li>
            <li><label>货量</label><input name="goodsQuantity" value="${requestScope.goodsSupply.goodsQuantity}" type="text"
                                           class="dfinput"/></li>
            <li><label>配货日期</label><input name="goodsTime" value="${requestScope.goodsSupply.goodsTime}" type="text"
                                          class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></li>
            <li><label>期望运价</label><input name="goodsPrice" value="${requestScope.goodsSupply.goodsPrice}" type="text"
                                         class="dfinput"/></li>
            <li><label>期望车型</label>
                <select name="goodsCarType" class="dfinput">
                    <option value="0"
                    ${requestScope.goodsSupply.goodsCarType == '0'?'selected=\"selected\"':''}>---请选择期望车型---
                    </option>
                    <option value="1"
                    ${requestScope.goodsSupply.goodsCarType == '1'?'selected=\"selected\"':''}>半挂车
                    </option>
                    <option value="2"
                    ${requestScope.goodsSupply.goodsCarType == '2'?'selected=\"selected\"':''}>冷藏车
                    </option>
                    <option value="3"
                    ${requestScope.goodsSupply.goodsCarType == '3'?'selected=\"selected\"':''}>起重车
                    </option>
                    <option value="4"
                    ${requestScope.goodsSupply.goodsCarType == '4'?'selected=\"selected\"':''}>保温车
                    </option>
                </select>
            </li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认发布"/></li>
        </ul>
    </form>

</div>


</body>

</html>
