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
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>


</head>

<body style="background:#f0f9fd;">
<div class="lefttop"><span></span>管理员后台</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico01.png"/></span>站内用户
        </div>
        <ul class="menuson">
            <li class="active"><cite></cite><a href="${pageContext.request.contextPath}/user/list" target="rightFrame">用户管理</a><i></i></li>
        </ul>
    </dd>


    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico02.png"/></span>站内公告
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${pageContext.request.contextPath}/stationInfo/list" target="rightFrame">站内公告</a><i></i></li>
            <li><cite></cite><a href="addStationInfo.jsp" target="rightFrame">发布公告</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico02.png"/></span>物流新闻
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${pageContext.request.contextPath}/news/list" target="rightFrame">物流新闻</a><i></i></li>
            <li><cite></cite><a href="addNews.jsp" target="rightFrame">发布新闻</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico02.png"/></span>物流信息
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${pageContext.request.contextPath}/goodsSupply/adminList" target="rightFrame">货源</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/carsSupply/adminList" target="rightFrame">车源</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/linesSupply/adminList" target="rightFrame">专线</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/storagesSupply/adminList" target="rightFrame">仓储</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/jobsSupply/adminList" target="rightFrame">招聘</a><i></i></li>
        </ul>
    </dd>

</dl>

</body>
</html>
