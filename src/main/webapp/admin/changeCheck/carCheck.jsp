<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>修改用户信息</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/kindeditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.idTabs.min.js"></script>

</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>修改信息状态</span></div>
    <form action="${pageContext.request.contextPath}/carsSupply/changeCheck" method="post">

        <ul class="forminfo">
            <li><input type="hidden" name="id" value="${carsSupply.id}"/></li>
            <li><label>信息状态</label>
                <label for="carCheck1"><input type="radio" id="carCheck1" name="carCheck"
                                                                    value="1"
                ${requestScope.carsSupply.carCheck=='1'?'checked=\"checked\"':''} />有效</label>
                <label for="carCheck2"><input type="radio" id="carCheck2" name="carCheck"
                                                                    value="0"
                ${requestScope.carsSupply.carCheck=='0'?'checked=\"checked\"':''} />作废</label>
            </li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认修改"/></li>
        </ul>
    </form>

</div>


</body>

</html>
