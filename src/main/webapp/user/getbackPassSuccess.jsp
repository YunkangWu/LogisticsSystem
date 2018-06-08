<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新用户注册</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>

</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>找回密码</span></div>
    <form>
        <ul class="forminfo">
            <li><label>您的密码为：</label>${requestScope.user.password}</li>
            <li>请妥善保管好您的密码</li>
        </ul>
    </form>

</div>
</body>
</html>
