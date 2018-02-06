<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 15:08
  Description: 编辑话题
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script src="../js/notice.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background: rgb(233, 241, 243);">

<div class="page-inner page-fixed" id="page-1511333173845" style="background-color:#e9f1f3">
    <form action="confirmUpdateNotice" method="post" id="confirmDoNoticeForm">
        <header class="header-item" style="background-color:#00758e">
            <a href="javascript:history.back(-1);" class="icon-back">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">编辑公告</h3>
            <a class="button fs30 active"  href=" javascript:;"  id="confirm">更新</a>
        </header>
        <div class="page-auto absolute">
            <div class="publish-page">
                <div class="input-box border-1px">
                    <div class="border-1px">
                        <input type="text" class="txt fs30" value="" name="title" id="title" placeholder="${notice.title}" autofocus="">
                    </div>
                    <div contenteditable="true" tabindex="-1">
                        <input type=" text" class="area fs30 needsfocus" value="" name="content" id="content" placeholder="${notice.content}">
                    </div>
                    <input type="hidden" name="courseid" value="${courseId}">
                    <input type="hidden" name="noticeid" value="${notice.noticeid}">
                    <input type="hidden" name="index" value="${index}">
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
<%--提示框--%>
<div class="" id="tipWindow" >
    <div class="gTips" ><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>

<script>
    $("#title").blur(judge);
    $("#content").blur(judge);

    setTimeout('$("#tipWindow").addClass("hidden")',2000);
</script>

