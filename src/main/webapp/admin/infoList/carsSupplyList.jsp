<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/resources/css/search.css" rel="stylesheet" type="text/css"/>
    <script src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            var carType = ${carType};
            if (carType != null) {
                $("#carType").attr("value", '${carType}');
            }
        })
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">物流信息</a></li>
        <li><a href="#">车源信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form action="${pageContext.request.contextPath}/carsSupply/list">
        <table width="100%" align="center">
            <tbody>
            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">车型&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <select name="carType" id="carType" class="select">
                        <option selected="selected" value="">请选择</option>
                        <option value="1">半挂车</option>
                        <option value="2">冷藏车</option>
                        <option value="3">起重车</option>
                        <option value="4">保温车</option>

                    </select>
                </td>
                <td width="18%" align="right">
                    <span class="black14_2">需&nbsp;&nbsp;求&nbsp;量&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="carCapacity" type="text" id="carCapacity" value="${carCapacity}" class="input6">
                </td>
            </tr>
            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">始&nbsp;&nbsp;发&nbsp;地&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <input name="carStart" id="carStart" value="${carStart}" class="input6">
                </td>
                <td width="18%" align="right">
                    <span class="black14_2">目&nbsp;&nbsp;的&nbsp;地&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="carEnd" id="carEnd" value="${carEnd}" class="input6">
                </td>
            </tr>

            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">发车日期&nbsp;</span>
                </td>
                <td width="24%" align="left" valign="middle" style="height: 29px;">
                    <input name="carTime" id="carTime" value="${carTime}" class="input6"
                           onclick="WdatePicker({dateFmt:'yyyyMMdd'})">
                </td>
            </tr>
            <tr height="35">
                <td colspan="2" align="right" style="padding-right: 10px;">
                    <input type="submit" value="搜索"
                           style="height:24px;width:121px;border-width:0px;">
                </td>
                <td align="left" colspan="2" style="padding-left: 40px;">
                    <input type="button" id="reset" value="清除条件"
                           style="height:24px;width:121px;border-width:0px;">
                </td>
            </tr>
            </tbody>
        </table>

        <table class="tablelist">

            <tr>
                <th>始发地</th>
                <th>→</th>
                <th>目的地</th>
                <th>车型</th>
                <th>载重</th>
                <th>信息状态</th>
                <th>发车日期</th>
                <th>查看</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${carsSupplyList}" var="carsSupply">
            <tr>
                <td>${carsSupply.carStart}</td>
                <th>→</th>
                <td>${carsSupply.carEnd}</td>
                <td><c:if test="${carsSupply.carType == '1'}">半挂车</c:if>
                    <c:if test="${carsSupply.carType == '2'}">冷藏车</c:if>
                    <c:if test="${carsSupply.carType == '3'}">起重车</c:if>
                    <c:if test="${carsSupply.carType == '4'}">保温车</c:if>
                </td>
                <td>${carsSupply.carCapacity}</td>
                <td><c:if test="${carsSupply.carStatus == '0'}">待交易</c:if>
                    <c:if test="${carsSupply.carStatus == '1'}">交易完成</c:if></td>
                <td><fmt:formatDate value="${carsSupply.carTime}" pattern="yyyy-MM-dd"/></td>
                <td><a href="${pageContext.request.contextPath}/carsSupply/detail?id=${carsSupply.id}"
                       class="tablelink">详细情况</a>
                    <a href="${pageContext.request.contextPath}/carsSupply/toChangeCheck?id=${carsSupply.id}"
                       class="tablelink">信息状态</a>
                </td>
            </tr>
            </c:forEach>

        </table>


        <div>
            <a href="${pageuri}&page=1"><img
                    src="${pageContext.request.contextPath}/resources/images/toleft_disabled.png" title="首页"></a>
            <c:if test="${pageModel.page>1}">
                <a href="${pageuri}&page=${pageModel.prev}"><img
                        src="${pageContext.request.contextPath}/resources/images/left_three.png" title="上一页"></a>
            </c:if>
            <c:if test="${pageModel.page<pageModel.last}">
                <a href="${pageuri}&page=${pageModel.next}"><img
                        src="${pageContext.request.contextPath}/resources/images/right_three.png" title="下一页"></a>
            </c:if>
            <a href="${pageuri}&page=${pageModel.last}"><img
                    src="${pageContext.request.contextPath}/resources/images/toright_disabled.png" title="尾页"></a>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a class="black14_2">第${pageModel.page}页/共${pageModel.pageCount}页,共${pageModel.totalCount}条</a>
        </div>


    </form>
</div>

<script>
    $(function () {
        $("#reset").click(function () {
            $("#carType").val("");
            $("#carStart").val("");
            $("#carCapacity").val("");
            $("#carEnd").val("");
            $("#carTime").val("");
        });
    });
</script>
</body>

</html>

