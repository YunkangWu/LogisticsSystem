<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新用户注册</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>

    <script>

        //过滤无效的找回密码请求
        function checkForm() {
            // 获得问题文本框的值:
            var userQuestion = document.getElementById("userQuestion").value;
            var userKey = document.getElementById("userKey").value;
            if (userQuestion == null || userQuestion == '') {
                alert("无效的找回密码请求！");
                return false;
            }else {
                if (userKey == null || userKey == '') {
                    alert("请输入您的答案！");
                    return false;
                }
            }


        }

        function getUerQuestion() {
            var username = document.getElementById("userName").value;
            //传统的ajax校验
            //1.创建异步交互对象，
            var xhr = createXmlHttp();
            // 2.设置监听
            xhr.onreadystatechange = function () {
                //xhr.readyState == 4  是表示后台处理完成了。
                //xhr.status == 200 是表示处理的结果是OK的。
                if (xhr.readyState == 4) {
                    if (xhr.status == 200) {
                        document.getElementById("userQuestion").value = xhr.responseText;
                    }
                }
            }
            // 3.打开连接
            xhr.open("GET", "${pageContext.request.contextPath}/user/getUserQuestion?username=" + username, true);
            // 4.发送
            xhr.send(null);
        }

        function createXmlHttp() {
            var xmlHttp;
            try {
                xmlHttp = new XMLHttpRequest();
            }
            catch (e) {
                try {// Internet Explorer
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                }
                catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    catch (e) {
                    }
                }
            }
            return xmlHttp;
        }

    </script>

</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>找回密码</span></div>
    <form action="${pageContext.request.contextPath}/user/getbackPass" method="post" onsubmit="return checkForm();">
        <ul class="forminfo">
            <li><label>请输入用户名</label><input name="userName" id="userName" type="text"
                                            class="dfinput" onblur="getUerQuestion()"/></li>
            <li><label>您设置的问题</label><input id="userQuestion" name="userQuestion" class="dfinput" type="text" disabled="true" style="color:#561dff;"/></li>
            <li><label>您的答案</label><input name="userKey" id="userKey" type="text" class="dfinput"/></li>
            <li><input type="submit" class="btn" value="找回密码"/>
        </ul>
    </form>

</div>
</body>
</html>
