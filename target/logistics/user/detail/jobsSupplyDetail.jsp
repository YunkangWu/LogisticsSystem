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
    <div class="formtitle"><span>招聘信息详情</span></div>
    <ul class="forminfo">

        <li><label>职位名称：</label><label>${jobsSupply.jobTitle}</label></li>
        <li><label>公司名称:</label><label>${jobsSupply.companyName}</label></li>
        <li><label>工作地点:</label><label>${jobsSupply.city}</label></li>
        <li><label>月薪:</label><label>${jobsSupply.salary}</label></li>
        <li><label>招聘中介:</label><label>${jobsSupply.jobBelong.companyName}</label></li>
        <li><label>联系人:</label><label>${jobsSupply.jobBelong.userName}</label></li>
        <li><label>联系电话:</label><label>${jobsSupply.jobBelong.tellphone}</label></li>
        <li><label>发布时间:</label><label><fmt:formatDate value="${jobsSupply.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></label></li>
    </ul>

</div>
</body>
</html>
