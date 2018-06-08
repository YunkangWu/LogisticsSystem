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


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">物流信息</a></li>
        <li><a href="#">专线信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form action="${pageContext.request.contextPath}/linesSupply/list">
        <table width="100%" align="center">
            <tbody>
            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">始&nbsp;&nbsp;发&nbsp;地&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <input name="lineStart" value="${lineStart}" id="lineStart" class="input6">
                </td>
                <td width="18%" align="right">
                    <span  class="black14_2">目&nbsp;&nbsp;的&nbsp;地&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="lineEnd" value="${lineEnd}" id="lineEnd" class="input6">
                </td>
            </tr>

            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">公司名称&nbsp;</span>
                </td>
                <td width="24%" align="left" valign="middle" style="height: 29px;">
                    &nbsp;<input name="companyName" value="${companyName}" id="companyName" class="input6">
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
                <th>公司名称</th>
                <th>发车频率</th>
                <th>运输时效</th>
                <th>查看</th>
            </tr>
            <tbody>
            <c:forEach items="${linesSupplyList}" var="linesSupply">
                <tr>
                    <td>${linesSupply.lineStart}</td>
                    <th>→</th>
                    <td>${linesSupply.lineEnd}</td>
                    <td>${linesSupply.lineBelong.companyName}</td>
                    <td>${linesSupply.lineFrequency}</td>
                    <td>${linesSupply.lineTransportTime}</td>
                    <td><a href="${pageContext.request.contextPath}/linesSupply/detail?id=${linesSupply.id}" class="tablelink">详细情况</a>
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

<script>
    $(function () {
        $("#reset").click(function () {
            $("#lineStart").val("");
            $("#lineEnd").val("");
            $("#companyName").val("");
        });
    });
</script>

</body>

</html>

