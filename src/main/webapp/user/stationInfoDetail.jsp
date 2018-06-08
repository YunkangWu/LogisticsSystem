<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
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

<div class="formbody">
    <div class="formtitle"><span>物流新闻详情</span></div>

        <ul class="forminfo">
            <li><label>站内公告</label><input name="infoTitle" disabled value="${stationInfo.infoTitle}" type="text"
                                          class="dfinput"/></li>
            <li><label>引用来源</label><input name="infoFrom" disabled value="${requestScope.stationInfo.infoFrom}" type="text"
                                          class="dfinput"/></li>
            <li><label>公告内容</label><textarea name="infoContent" disabled
                                           class="textinput">${stationInfo.infoContent}</textarea></li>
        </ul>

</div>


</body>

</html>
