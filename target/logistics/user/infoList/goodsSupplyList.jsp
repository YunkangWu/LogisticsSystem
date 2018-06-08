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
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">物流信息</a></li>
        <li><a href="#">货源信息</a></li>
    </ul>
</div>

<div class="rightinfo">

    <form action="${pageContext.request.contextPath}/goodsSupply/list">
        <table width="100%" align="center">
            <tbody>
            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">货&nbsp;&nbsp;物&nbsp;名&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <input name="goodsName" id="goodsName" value="${goodsName}" class="input6">
                </td>
                <td width="18%" align="right">
                    <span class="black14_2">货&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="goodsQuantity" type="text" id="goodsQuantity" value="${goodsQuantity}" class="input6">
                </td>
            </tr>
            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">始&nbsp;&nbsp;发&nbsp;地&nbsp;</span>
                </td>
                <td width="24%" align="left">
                    <input name="goodsStart" id="goodsStart" value="${goodsStart}" class="input6">
                </td>
                <td width="18%" align="right">
                    <span class="black14_2">目&nbsp;&nbsp;的&nbsp;地&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="goodsEnd" id="goodsEnd" value="${goodsEnd}" class="input6">
                </td>
            </tr>

            <tr height="30">
                <td width="22%" align="right">
                    <span class="black14_2">配货起始日期&nbsp;</span>
                </td>
                <td width="24%" align="left" valign="middle" style="height: 29px;">
                    <input name="goodsTimeStart" id="goodsTimeStart" value="${goodsTimeStart}" class="input6"
                           onclick="WdatePicker({dateFmt:'yyyyMMdd'})">
                <td width="18%" align="right">
                    <span class="black14_2">截止日期&nbsp;</span>
                </td>
                <td width="36%" align="left">
                    <input name="goodsTimeEnd" id="goodsTimeEnd" value="${goodsTimeEnd}" class="input6"
                           onclick="WdatePicker({dateFmt:'yyyyMMdd'})">
                </td>
            </tr>
            <tr height="35">
                <td colspan="2" align="right" style="padding-right: 10px;">
                    <input type="submit" value="搜索"
                           style="height:24px;width:121px;border-width:0px;">
                </td>
                <td align="left" colspan="2" style="padding-left: 40px;">
                    <input type="button" name="reset" id="reset" value="清除条件"
                           style="height:24px;width:121px;border-width:0px;">
                </td>
            </tr>
            </tbody>
        </table>


        <table class="tablelist">

            <thead>
            <tr>
                <th>始发地</th>
                <th>→</th>
                <th>目的地</th>
                <th>货物名</th>
                <th>货量</th>
                <th>信息状态</th>
                <th>配货日期</th>
                <th>查看</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${goodsSupplyList}" var="goodsSupply">
                <tr>
                    <td>${goodsSupply.goodsStart}</td>
                    <th>→</th>
                    <td>${goodsSupply.goodsEnd}</td>
                    <td>${goodsSupply.goodsName}</td>
                    <td>${goodsSupply.goodsQuantity}</td>
                    <td><c:if test="${goodsSupply.goodsStatus == '0'}">待交易</c:if>
                        <c:if test="${goodsSupply.goodsStatus == '1'}">交易完成</c:if></td>
                    <td><fmt:formatDate value="${goodsSupply.goodsTime}" pattern="yyyy-MM-dd"/></td>
                    <td><a href="${pageContext.request.contextPath}/goodsSupply/detail?id=${goodsSupply.id}"
                           class="tablelink">详细情况</a>
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
            $("#goodsName").val("");
            $("#goodsQuantity").val("");
            $("#goodsStart").val("");
            $("#goodsEnd").val("");
            $("#goodsTimeStart").val("");
            $("#goodsTimeEnd").val("");
        });
    });
</script>
</body>

</html>

