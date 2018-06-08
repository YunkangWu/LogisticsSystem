<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/editor/kindeditor.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.idTabs.min.js"></script>
    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">物流新闻</a></li>
        <li><a href="#">发布新闻</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>新闻</span></div>
    <form action="${pageContext.request.contextPath}/news/add" method="post">
        <ul class="forminfo">
            <li><label>新闻标题<b>*</b></label><input name="newsTitle" value="${requestScope.news.newsTitle}" type="text"
                                          class="dfinput"/></li>

            <li><label>类型<b>*</b></label>


                <div class="vocation">
                    </select>
                    <select name="newsType" class="dfinput">
                        <option value="0"
                        ${requestScope.news.newsType == '0'?'selected=\"selected\"':''}>---请选择新闻类型---
                        </option>
                        <option value="1"
                        ${requestScope.news.newsType == '1'?'selected=\"selected\"':''}>物流数据
                        </option>
                        <option value="2"
                        ${requestScope.news.newsType == '2'?'selected=\"selected\"':''}>综合资讯
                        </option>
                        <option value="3"
                        ${requestScope.news.newsType == '3'?'selected=\"selected\"':''}>行业分析
                        </option>
                        <option value="4"
                        ${requestScope.news.newsType == '4'?'selected=\"selected\"':''}>企业动态
                        </option>
                    </select>
                </div>

            </li>

            <li><label>引用来源</label><input name="newsFrom" value="${requestScope.news.newsFrom}" type="text"
                                          class="dfinput"/></li>
            <li><label>正文</label><input id="content7" name="newsContent"
                                        value="${requestScope.news.newsContent}"
                                        class="textinput"/></li>
            <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认发布"/></li>
        </ul>
    </form>

</div>


</body>

</html>
