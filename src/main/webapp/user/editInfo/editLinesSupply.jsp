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
        <li><a href="#">专线信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>专线信息</span></div>
    <form action="${pageContext.request.contextPath}/linesSupply/editLinesSupply" method="post">
        <ul class="forminfo">
            <li><input hidden name="id" value="${requestScope.linesSupply.id}"></li>
            <li><label>始发地</label><input name="lineStart" value="${requestScope.linesSupply.lineStart}" type="text"
                                         class="dfinput"/></li>
            <li><label>目的地</label><input name="lineEnd" value="${requestScope.linesSupply.lineEnd}" type="text"
                                         class="dfinput"/></li>
            <li><label>发车频率</label><input name="lineFrequency" value="${requestScope.linesSupply.lineFrequency}" type="text"
                                          class="dfinput"/></li>
            <li><label>运输时效</label><input name="lineTransportTime" value="${requestScope.linesSupply.lineTransportTime}" type="text"
                                          class="dfinput"/></li>
            <li><label>专线运价</label><input name="linePrice" value="${requestScope.linesSupply.linePrice}" type="text"
                                          class="dfinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>

        </ul>
    </form>

</div>


</body>

</html>
