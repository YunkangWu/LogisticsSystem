<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>物流信息管理平台</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/cloud.js" type="text/javascript"></script>

    <%--云层飘动样式--%>
    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/resources/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录物流信息管理系统</span>
    <ul>
        <li><a href="admin/login.jsp">进入管理员后台</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox">
        <form id="user_login" action="login/user" method="post">
            <ul>
                <li><input name="user.userName" type="text" class="loginpwd" value=""
                           onclick="JavaScript:this.value=''"/></li>
                <li><input name="user.password" type="password" class="loginpwd" value=""
                           onclick="JavaScript:this.value=''"/>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"/><label><a
                        href="${pageContext.request.contextPath}/user/getbackPass.jsp">忘记密码？</a></label><label><a
                        href="${pageContext.request.contextPath}/user/register.jsp">免费注册</a></label></li>
            </ul>
        </form>

    </div>

</div>


<div class="loginbm"> 2017 <a href="http://www.cdu.edu.cn/">cdu</a> 软件工程 吴云康 毕业作品</div>


</body>
</html>
