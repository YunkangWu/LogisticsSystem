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
<div class="lefttop"><span></span>物流信息管理平台</div>

<dl class="leftmenu">

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico01.png"/></span>物流信息
        </div>
        <ul class="menuson">

            <li class="active"><cite></cite><a href="${pageContext.request.contextPath}/goodsSupply/list" target="rightFrame">货源</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/carsSupply/list" target="rightFrame">车源</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/linesSupply/list" target="rightFrame">专线</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/storagesSupply/list" target="rightFrame">仓储</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/jobsSupply/list" target="rightFrame">招聘</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico02.png"/></span>发布信息
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${pageContext.request.contextPath}/user/addInfo/addCarSupply.jsp" target="rightFrame">车源</a><i></i></li>
        </ul>
    </dd>

    <dd>
        <div class="title">
            <span><img src="${pageContext.request.contextPath}/resources/images/leftico02.png"/></span>会员中心
        </div>
        <ul class="menuson">
            <li><cite></cite><a href="${pageContext.request.contextPath}/user/manage" target="rightFrame">管理发布信息</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/stationInfo/userList" target="rightFrame">站内公告</a></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/news/userList" target="rightFrame">物流新闻</a><i></i></li>
            <li><cite></cite><a href="${pageContext.request.contextPath}/user/prCenter" target="rightFrame">个人中心</a><i></i></li>
        </ul>
    </dd>

</dl>

</body>
</html>
