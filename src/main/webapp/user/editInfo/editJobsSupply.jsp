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
        <li><a href="#">招聘信息</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>招聘信息</span></div>
    <form action="${pageContext.request.contextPath}/jobsSupply/editJobsSupply" method="post">
        <ul class="forminfo">
            <li><input hidden name="id" value="${requestScope.jobsSupply.id}"></li>
            <li><label>职位名称</label><input name="jobTitle" value="${requestScope.jobsSupply.jobTitle}" type="text"
                                          class="dfinput"/></li>
            <li><label>公司名称</label><input name="companyName" value="${requestScope.jobsSupply.companyName}" type="text"
                                          class="dfinput"/></li>
            <li><label>工作地点</label><input name="city" value="${requestScope.jobsSupply.city}" type="text"
                                          class="dfinput"/></li>
            <li><label>月薪</label><input name="salary" value="${requestScope.jobsSupply.salary}" type="text"
                                        class="dfinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>

        </ul>
    </form>

</div>


</body>

</html>
