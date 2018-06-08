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
        function checkForm() {
            // 校验用户名:
            // 获得用户名文本框的值:
            var username = document.getElementById("userName").value;
            if (username == null || username == '') {
                alert("用户名不能为空!");
                return false;
            }
            // 校验密码:
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


        function checkUsername() {
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
                        document.getElementById("span1").innerHTML = xhr.responseText;
                    }
                }
            }
            // 3.打开连接
            xhr.open("GET", "${pageContext.request.contextPath}/user/checkUsername?username=" + username, true);
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


        //企业用户注册信息显示隐藏
        function to_change() {
            var obj = document.getElementsByName('userType');
            /*    console.log(obj);*/
            for (var i = 0; i < obj.length; i++) {
                if (obj[i].checked == true) {
                    if (obj[i].value == '1') {
                        $("#company").hide();
                    } else if (obj[i].value == '2') {
                        $("#company").toggle();
                    }
                }
            }
        }
    </script>

</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>新用户注册</span></div>
    <form action="${pageContext.request.contextPath}/user/register" method="post" onsubmit="return checkForm();">
        <ul class="forminfo">
            <li><label>用户类型</label>
                <label for="userType1" onclick="to_change()"><input type="radio" id="userType1" name="userType"
                                                                    value="2" class="hide"
                ${(requestScope.user.userType=='2' || requestScope.user.userType==null)?'checked=\"checked\"':''} />企业用户</label>
                <label for="userType2" onclick="to_change()"><input type="radio" id="userType2" name="userType"
                                                                    value="1" class="show"
                ${requestScope.user.userType=='1'?'checked=\"checked\"':''} />个人用户</label>
            </li>
            <li><label>用户名</label><input name="userName" id="userName" value="${requestScope.user.userName}"
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

            <div id="company">
                <li><label>企业名称</label><input name="companyName" id="companyName"
                                              value="${requestScope.user.companyName}"
                                              type="text"
                                              class="dfinput"/>
                <li><label>法人代表</label><input name="companyBelong" id="companyBelong"
                                              value="${requestScope.user.companyBelong}"
                                              type="text"
                                              class="dfinput"/>
                <li><label>企业类型</label>
                    <select name="companyType" class="dfinput">
                        <option value="0"
                        ${requestScope.user.companyType == '0'?'selected=\"selected\"':''}>---请选择企业类型---
                        </option>
                        <option value="1"
                        ${requestScope.user.companyType == '1'?'selected=\"selected\"':''}>货源公司
                            如果您想发布货源信息，请选择
                        </option>
                        <option value="2"
                        ${requestScope.user.companyType == '2'?'selected=\"selected\"':''}>专线公司
                            如果您想发布专线信息，请选择
                        </option>
                        <option value="3"
                        ${requestScope.user.companyType == '3'?'selected=\"selected\"':''}>仓储公司
                            如果您想发布仓储信息，请选择
                        </option>
                        <option value="4"
                        ${requestScope.user.companyType == '3'?'selected=\"selected\"':''}>物流中介
                            如果您想发布招聘信息，请选择
                        </option>
                    </select>
                </li>
                <li><label>所属行业</label>
                    <select name="companyIndustry" class="dfinput">
                        <option value="0"
                        ${requestScope.user.companyIndustry == '0'?'selected=\"selected\"':''}>---请选择所属行业---
                        </option>
                        <option value="1"
                        ${requestScope.user.companyIndustry == '1'?'selected=\"selected\"':''}>食品
                        </option>
                        <option value="2"
                        ${requestScope.user.companyIndustry == '2'?'selected=\"selected\"':''}>服装
                        </option>
                        <option value="3"
                        ${requestScope.user.companyIndustry == '3'?'selected=\"selected\"':''}>农业
                        </option>
                        <option value="4"
                        ${requestScope.user.companyIndustry == '4'?'selected=\"selected\"':''}>化工
                        </option>
                    </select>
                </li>
            </div>

            <li><input name="" type="submit" class="btn" value="确认注册"/>
                <label>&nbsp;</label><input id="reset" name="reset" type="button" class="btn" value="重置"/></li>
        </ul>
    </form>

</div>


</body>
<script>
    $(function () {
        $("#reset").click(function () {
            $("#userName").val("");
            $("#password").val("");
            $("#repassword").val("");
            $("#location").val("");
            $("#tellphone").val("");
            $("#email").val("");
            $("#companyName").val("");
            $("#companyBelong").val("");
        });
    });
</script>

</html>
