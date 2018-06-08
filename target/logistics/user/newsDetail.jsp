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
    <script type="text/javascript">
        KE.show({
            id: 'content7',
            cssPath: './index.css'
        });
    </script>

</head>

<body>

<div class="formbody">
    <div class="formtitle"><span>站内公告详情</span></div>

    <ul class="forminfo">
        <li><label>新闻标题</label><input name="newsTitle" disabled value="${requestScope.news.newsTitle}" type="text"
                                      class="dfinput"/></li>

        <li><label>类型</label>
            <div class="vocation">
                <select name="newsType" disabled class="dfinput">
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

        <li><label>引用来源</label><input name="newsFrom" disabled value="${requestScope.news.newsFrom}" type="text"
                                      class="dfinput"/></li>
        <li><label>新闻正文</label><textarea name="newsContent" disabled
                                         class="textinput">${requestScope.news.newsContent}</textarea></li>
    </ul>

</div>


</body>

</html>
