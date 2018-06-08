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
            <li><input name="" type="submit" class="btn" value="确认修改"/></li>
        </ul>
    </form>

</div>


</body>

</html>
