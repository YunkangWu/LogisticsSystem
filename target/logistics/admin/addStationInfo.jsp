<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/kindeditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">站内公告</a></li>
        <li><a href="#">发布公告</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle" id="usual1"><span>站内公告</span></div>
    <form action="${pageContext.request.contextPath}/stationInfo/add" method="post">
        <ul class="forminfo">
            <li><label>站内公告</label><input name="infoTitle" value="${requestScope.stationInfo.infoTitle}" type="text"
                                          class="dfinput"/></li>
            <li><label>引用来源</label><input name="infoFrom" value="${requestScope.stationInfo.infoFrom}" type="text"
                                          class="dfinput"/></li>
            <li><label>公告内容</label><input id="content7" name="infoContent"
                                          value="${requestScope.stationInfo.infoContent}"
                                          class="textinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认发布"/></li>
        </ul>
    </form>

</div>


</body>

</html>
