<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>

    <script>

        //企业用户注册信息显示隐藏
        function to_change() {
            var obj = document.getElementsByName('userType');
            console.log(obj);
            for (var i = 0; i < obj.length; i++) {
                if (obj[i].checked == true) {
                    if (obj[i].value == '1') {
                        $("#company")[0].style.display = "none";
                    } else if (obj[i].value == '2') {
                        $("#company")[0].style.display = "block";
                    }
                }
            }
        }
    </script>
</head>

<body onload="to_change()">
<div class="formbody">
    <div class="formtitle"><span>修改用户信息</span></div>
    <form action="${pageContext.request.contextPath}/user/editUser" method="post">
        <ul class="forminfo">
            <li><input type="hidden" name="id" value="${user.id}"/></li>
            <li><label>用户类型</label>
                <label for="userType1" onclick="to_change()"><input type="radio" id="userType1" name="userType"
                                                                    value="2"
                ${requestScope.user.userType=='2'?'checked=\"checked\"':''} />企业用户</label>
                <label for="userType2" onclick="to_change()"><input type="radio" id="userType2" name="userType"
                                                                    value="1"
                ${requestScope.user.userType=='1'?'checked=\"checked\"':''} />个人用户</label>
            </li>
            <li><label>是否有效</label>
                <label for="userCheck1"><input type="radio" id="userCheck1" name="userCheck" value="1"
                ${requestScope.user.userCheck=='1'?'checked=\"checked\"':''} />有效</label>
                <label for="userCheck2"><input type="radio" id="userCheck2" name="userCheck" value="0"
                ${requestScope.user.userCheck=='0'?'checked=\"checked\"':''} />无效</label>
            </li>
            <li><label>用户名</label><input disabled name="userName" value="${user.userName}" type="text"
                                         class="dfinput"/></li>
            <li><label>密码</label><input name="password" id="password" value="${user.password}"
                                        type="text"
                                        class="dfinput"/></li>
            <li><label>地址</label><input name="location" id="location" value="${user.location}" type="text"
                                        class="dfinput"/></li>
            <li><label>电话</label><input name="tellphone" id="tellphone" value="${user.tellphone}"
                                        type="text"
                                        class="dfinput"/></li>
            <li><label>E-mail</label><input name="email" id="email" value="${user.email}" type="text"
                                            class="dfinput"/></li>

            <div id="company" style="display:none;">
                <li><label>企业名称</label><input name="companyName" id="companyName"
                                              value="${user.companyName}"
                                              type="text"
                                              class="dfinput"/>
                <li><label>法人代表</label><input name="companyBelong" id="companyBelong"
                                              value="${user.companyBelong}"
                                              type="text"
                                              class="dfinput"/>
                <li><label>企业类型</label>
                    <select name="companyType" class="dfinput">
                        <option value="0"
                        ${user.companyType == '0'?'selected=\"selected\"':''}>---请选择企业类型---
                        </option>
                        <option value="1"
                        ${user.companyType == '1'?'selected=\"selected\"':''}>货源公司
                            如果您想发布货源信息，请选择
                        </option>
                        <option value="2"
                        ${user.companyType == '2'?'selected=\"selected\"':''}>专线公司
                            如果您想发布专线信息，请选择
                        </option>
                        <option value="3"
                        ${user.companyType == '3'?'selected=\"selected\"':''}>仓储公司
                            如果您想发布仓储信息，请选择
                        </option>
                        <option value="4"
                        ${user.companyType == '4'?'selected=\"selected\"':''}>物流中介
                            如果您想发布招聘信息，请选择
                        </option>
                    </select>
                </li>
                <li><label>所属行业</label>
                    <select name="companyIndustry" class="dfinput">
                        <option value="0"
                        ${user.companyIndustry == '0'?'selected=\"selected\"':''}>---请选择所属行业---
                        </option>
                        <option value="1"
                        ${user.companyIndustry == '1'?'selected=\"selected\"':''}>食品
                        </option>
                        <option value="2"
                        ${user.companyIndustry =='2'?'selected=\"selected\"':''}>服装
                        </option>
                        <option value="3"
                        ${user.companyIndustry == '3'?'selected=\"selected\"':''}>农业
                        </option>
                        <option value="4"
                        ${user.companyIndustry == '4'?'selected=\"selected\"':''}>化工
                        </option>
                    </select>
                </li>
            </div>

            <li><input name="" type="submit" class="btn" value="确认修改"/></li>
        </ul>
    </form>

</div>


</body>

</html>
