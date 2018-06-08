<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>物流信息管理系统后台</title>
    <link href="${pageContext.request.contextPath}/resources/css/style_adminlogin.css" rel="stylesheet"
          type="text/css"/>
    <script language="JavaScript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

    <style>
        #mainBody {
            width: 100%;
            height: 100%;
            position: absolute;
            z-index: -1;
        }

        .cloud {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100%;
            height: 100%;
            background: url(${pageContext.request.contextPath}/resources/images/cloud.png) no-repeat;
            z-index: 1;
            opacity: 0.5;
        }

        #cloud2 {
            z-index: 2;
        }
    </style>

</head>

<body style="background-color:#1c77ac; background-image:url(${pageContext.request.contextPath}/resources/images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录物流信息管理系统后台</span>
    <ul>
        <li><a href="${pageContext.request.contextPath}/login.jsp">前台用户登录</a></li>
    </ul>
</div>

<div class="loginbody">

    <span class="systemlogo"></span>

    <div class="loginbox">
        <form id="user_login" action="${pageContext.request.contextPath}/login/admin" method="post">
            <ul>
                <li><input name="user.userName" type="text" class="loginpwd" value=""
                           onclick="JavaScript:this.value=''"/></li>
                <li><input name="user.password" type="password" class="loginpwd" value=""
                           onclick="JavaScript:this.value=''"/>
                </li>
                <li><input name="" type="submit" class="loginbtn" value="登录"/>
                    <%--<label><input name="" type="checkbox" value="" checked="checked"/>记住密码</label>--%>
                </li>
            </ul>
        </form>

    </div>

</div>


<div class="loginbm"> 2017 <a href="http://www.cdu.edu.cn/">cdu</a> 软件工程 吴云康 毕业作品</div>


</body>

</html>
