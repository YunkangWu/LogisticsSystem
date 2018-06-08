<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>个人用户基本信息修改</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>

    <script>
        function checkForm() {
            var userQuestion = document.getElementById("userQuestion").value;
            if (userQuestion == null || userQuestion == '') {
                alert("请设置您的问题!");
                return false;
            }
            var userKey = document.getElementById("userKey").value;
            if (userKey == null || userKey == '') {
                alert("请输入您的答案!");
                return false;
            }
            // 获得密码框的值:
            var password = document.getElementById("password").value;
            if (password == null || password == '') {
                alert("密码不能为空!");
                return false;
            }
            // 校验确认密码:
            var repassword = document.getElementById("repassword").value;
            if (repassword != password) {
                alert("两次密码输入不一致!");
                return false;
            }
        }
    </script>
</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>用户基本信息修改</span></div>
    <form action="${pageContext.request.contextPath}/user/editSuccess" method="post" onsubmit="return checkForm();">
        <ul class="forminfo">
            <li><input hidden name="id" value="${user.id}"></li>
            <li><label>用户名</label><input name="userName" disabled id="userName" value="${requestScope.user.userName}"
                                         type="text"
                                         class="dfinput" onblur="checkUsername()"/><i id="span1"></i></li>
            <li><label>密码</label><input name="password" id="password" value="${requestScope.user.password}"
                                        type="password"
                                        class="dfinput"/></li>
            <li><label>确认密码</label><input name="repassword" id="repassword" value="${requestScope.user.password}"
                                          type="password"
                                          class="dfinput"/></li>
            <li><label>地址</label><input name="location" id="location" value="${requestScope.user.location}" type="text"
                                        class="dfinput"/></li>
            <li><label>电话</label><input name="tellphone" id="tellphone" value="${requestScope.user.tellphone}"
                                        type="text"
                                        class="dfinput"/></li>
            <li><label>E-mail</label><input name="email" id="email" value="${requestScope.user.email}" type="text"
                                            class="dfinput"/></li>
            <li><input name="" type="submit" class="btn" value="确认修改"/></li>
        </ul>
    </form>

</div>


</body>

</html>
