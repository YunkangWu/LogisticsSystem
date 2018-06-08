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
    <div class="formtitle"><span>专线信息详情</span></div>
    <ul class="forminfo">

        <li><label>始发地：</label><label>${linesSupply.lineStart}</label></li>
        <li><label>目的地:</label><label>${linesSupply.lineEnd}</label></li>
        <li><label>发车频率:</label><label>${linesSupply.lineFrequency}</label></li>
        <li><label>运输时效:</label><label>${linesSupply.lineTransportTime}</label></li>
        <li><label>专线运价:</label><label>${linesSupply.linePrice}</label></li>
        <li><label>物流商:</label><label>${linesSupply.lineBelong.companyName}</label></li>
        <li><label>联系人:</label><label>${linesSupply.lineBelong.userName}</label></li>
        <li><label>联系电话:</label><label>${linesSupply.lineBelong.tellphone}</label></li>
        <li><label>发布时间:</label><label><fmt:formatDate value="${linesSupply.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></label></li>
    </ul>

</div>
</body>
</html>
