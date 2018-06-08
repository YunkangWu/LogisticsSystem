<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
        <li><a href="#">管理发布信息</a></li>
        <li><a href="#">车源信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>车源信息</span></div>
    <form action="${pageContext.request.contextPath}/carsSupply/editCarsSupply" method="post">
        <ul class="forminfo">
            <li><input hidden name="id" value="${requestScope.carsSupply.id}"></li>
            <li><input hidden name="createTime" value="${requestScope.carsSupply.createTime}"></li>
            <li><label>始发地</label><input name="carStart" value="${requestScope.carsSupply.carStart}" type="text"
                                         class="dfinput"/></li>
            <li><label>目的地</label><input name="carEnd" value="${requestScope.carsSupply.carEnd}" type="text"
                                         class="dfinput"/></li>
            <li><label>车型</label>
                <select name="carType" class="dfinput">
                    <option value="0"
                    ${requestScope.carsSupply.carType == '0'?'selected=\"selected\"':''}>---请选择您的车型---
                    </option>
                    <option value="1"
                    ${requestScope.carsSupply.carType == '1'?'selected=\"selected\"':''}>半挂车
                    </option>
                    <option value="2"
                    ${requestScope.carsSupply.carType == '2'?'selected=\"selected\"':''}>冷藏车
                    </option>
                    <option value="3"
                    ${requestScope.carsSupply.carType == '3'?'selected=\"selected\"':''}>起重车
                    </option>
                    <option value="4"
                    ${requestScope.carsSupply.carType == '4'?'selected=\"selected\"':''}>保温车
                    </option>
                </select>
            <li><label>载重</label><input name="carCapacity" value="${requestScope.carsSupply.carCapacity}" type="text"
                                        class="dfinput"/></li>
            <li><label>发车日期</label>
                <input name="carTime" value="<fmt:formatDate value="${carsSupply.carTime}" pattern="yyyy-MM-dd"/>" type="text"
                                          class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/></li>
            <li><label>运价</label><input name="carPrice" value="${requestScope.carsSupply.carPrice}" type="text"
                                        class="dfinput"/></li>
            <li><label>交易状态</label>
                <label for="carStatus1"><input type="radio" id="carStatus1" name="carStatus"
                                              value="0"
                ${requestScope.carsSupply.carStatus=='0'?'checked=\"checked\"':''} />待交易</label>
                <label for="carStatus2"><input type="radio" id="carStatus2" name="carStatus"
                                              value="1"
                ${requestScope.carsSupply.carStatus=='1'?'checked=\"checked\"':''} />交易完成</label>
            </li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>

        </ul>
    </form>

</div>


</body>

</html>
