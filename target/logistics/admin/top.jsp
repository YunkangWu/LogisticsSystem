<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //顶部导航切换
            $(".nav li a").click(function () {
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>


</head>

<body style="background:url(${pageContext.request.contextPath}/resources/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main.jsp" target="_parent"><img src="${pageContext.request.contextPath}/resources/images/logo.png" title="系统首页"/></a>
</div>

<ul class="nav">
    <li><a href="${pageContext.request.contextPath}/user/list" target="rightFrame" class="selected"><img src="${pageContext.request.contextPath}/resources/images/icon01.png" title="工作台"/>
        <h2>工作台</h2></a></li>
    <%--<li><a href="tab.html" target="rightFrame"><img src="${pageContext.request.contextPath}/resources/images/icon06.png" title="后台权限"/>--%>
    <%--<h2>后台权限</h2></a></li>--%>
</ul>

<div class="topright">
    <ul>
        <li><span><img src="${pageContext.request.contextPath}/resources/images/help.png" title="帮助" class="helpimg"/></span><a href="#">关于</a></li>
        <li><a href="${pageContext.request.contextPath}/admin/login.jsp" target="_parent">退出</a></li>
    </ul>

    <div class="user">
        <span>欢迎您，管理员：${sessionScope.admin.admin}</span>
    </div>

</div>

</body>
</html>