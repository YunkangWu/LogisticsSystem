<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>设置找回密码的问题</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
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
    }
    </script>
</head>
<body>
<div class="formbody">
    <div class="formtitle"><span>设置找回密码问题</span></div>
    <form action="${pageContext.request.contextPath}/user/setQuestionSuccess" method="post"
          onsubmit="return checkForm();">
        <ul class="forminfo">
            <li><input hidden name="id" value="${requestScope.user.id}"></li>
            <li><label>您的用户名</label><input name="userName" disabled type="text" value="${requestScope.user.userName}"
                                           class="dfinput"/></li>
            <li><label>您设置的问题</label><input id="userQuestion" name="userQuestion" class="dfinput" type="text"/></li>
            <li><label>您的答案</label><input name="userKey" id="userKey" type="text" class="dfinput"/></li>
            <li><input type="submit" class="btn" value="确认设置"/>
        </ul>
    </form>

</div>
</body>
</html>
