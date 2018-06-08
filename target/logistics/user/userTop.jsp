<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script type="text/javascript">

        function about() {
            window.open('about.html', '_parent', 'height=100, width=400, top=400, left=400, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no')
        }

    </script>


</head>

<body style="background:url(${pageContext.request.contextPath}/resources/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.jsp" target="_parent"><img src="${pageContext.request.contextPath}/resources/images/logo.png"
                                             title="系统首页"/></a>
</div>

<div class="topright">
    <ul>
        <li><span><img src="${pageContext.request.contextPath}/resources/images/help.png" title="帮助"
                       class="helpimg"/></span><a href="javascript:void(0)" onclick="about()">关于</a></li>
        <li><a href="${pageContext.request.contextPath}/login/logout" target="_parent">退出</a></li>
    </ul>

    <div class="user">
        <span>欢迎您，个人用户：${sessionScope.user.userName}</span>
    </div>

</div>

</body>
</html>