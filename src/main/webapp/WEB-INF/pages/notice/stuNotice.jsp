<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 15:29
  Description: 学生公告 板块
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>金院课堂</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Cache" content="no-cache">
    <link type="text/css" href="../css/common/common-9baddc8954.css" rel="stylesheet">
    <link href="../css/common/layer.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery-3.2.1.min.js"></script>

    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner" id="page-course">
    <header class="header-item" style="background-color: rgb(0,117,142);">
        <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow" id="coursename">${course.cname}</h3>

    </header>
    <form action="stuAttend" method="post" id="goBackForm">
        <nav class="coursenav fs30" style="background-color: rgb(0,117,142);">
            <a href="javascript:document:goBackForm.submit();" class="">课堂考勤</a>
            <a href="javascript:;" class="active">教师公告</a>
        </nav>
        <input type="hidden" name="index" value="${index}">
    </form>
    <!-- 公告列表 -->
    <div class="mainView workspace" style="background-image: url(/img/notice/noNotice.png);background-repeat:no-repeat;background-position: center;">
        <div class="notice-list-container">
            <div class="content">
                <ul id="notice-lists" class="notice-lists announce-notify-lists">
                    <c:forEach items="${noticeList}" var="noticeList" varStatus="status">
                        <li class="href" data-sort="0">
                                <%--点击每一个详情--%>
                            <a href="noticeDetail?noticeId=${noticeList.noticeid}">
                                <div class="notice-title">
                                    <h3 class="notice-name fs36" style="word-wrap: break-word;">
                                            ${noticeList.title}
                                    </h3>
                                </div>
                            </a>
                            <div class="notice-content">
                                <div class="fs28 limit">
                                        ${noticeList.content}
                                </div>
                            </div>
                            <div class="notify-annex-talk">
                                <time class="notice-timer fs24">发布时间：${noticeList.createtime}</time>
                            </div>

                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
