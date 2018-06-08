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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            var storageType = ${storageType};
            if (storageType != null) {
                $("#storageType").attr("value", '${storageType}');
            }
        })
    </script>
</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">物流信息</a></li>
        <li><a href="#">仓储信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form action="${pageContext.request.contextPath}/storagesSupply/adminList">
        <table width="100%" align="center">
            <tbody>
            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">所在城市&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <input name="storagesCity" value="${storagesCity}" id="storagesCity" class="input6">
                </td>
                <td width="18%" align="right">
                    <span class="black14_2">仓储容量&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="capacity" value="${capacity}" id="capacity" class="input6">
                </td>
            </tr>

            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">仓储类型&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <select name="storageType" id="storageType" class="select">
                        <option selected="selected" value="">请选择</option>
                        <option value="1">普通仓储</option>
                        <option value="2">冷藏仓储</option>
                        <option value="3">恒温仓储</option>
                    </select>
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

            <thead>
            <tr>
                <th>所在城市</th>
                <th>详细地址</th>
                <th>仓储容量</th>
                <th>仓储类型</th>
                <th>查看</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${storagesSupplyList}" var="storagesSupply">
                <tr>
                    <td>${storagesSupply.storagesCity}</td>
                    <td>${storagesSupply.storagesLocation}</td>
                    <td>${storagesSupply.capacity}</td>
                    <td><c:if test="${storagesSupply.storageType == '1'}">普通仓储</c:if>
                        <c:if test="${storagesSupply.storageType == '2'}">冷藏仓储</c:if>
                        <c:if test="${storagesSupply.storageType == '3'}">恒温仓储</c:if>
                    </td>
                    <td><a href="${pageContext.request.contextPath}/storagesSupply/detail?id=${storagesSupply.id}"
                           class="tablelink">详细情况</a>
                        <a href="${pageContext.request.contextPath}/storagesSupply/toChangeCheck?id=${storagesSupply.id}"
                           class="tablelink">信息状态</a>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
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

</body>

<script>
    $(function () {
        $("#reset").click(function () {
            $("#storageType").val("");
            $("#storagesCity").val("");
            $("#capacity").val("");
        });
    });
</script>

</html>

