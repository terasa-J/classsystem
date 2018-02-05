<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 13:54
  Description:“学生”板块 —— 加入班级
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
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }

    </style>
</head>
<body>

<div class="page-inner page-fixed" id="page-1510890771684" style="background-color:#ececec">
    <form id="attendCourseForm" action="confirmAttendCourse" method="post">
        <header class="header-item" style="background-color:#464646">
            <a href="javascript:history.back(-1)" class="icon-back">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">加入班级</h3>
            <input type="submit" class="button fs28" value="确认">
            <%--未加事件--%>
        </header>
        <div class="page-auto absolute">
            <div class="edit-box">
                <div class="input-box">
                    <div class="border-1px">
                        <input class="txt" type="text" placeholder="输入邀请码" name="invitationCode" autofocus>
                    </div>
                    <p class="fs26">通过输入6位邀请码加入班级</p>
                </div>
            </div>
        </div>
    </form>
</div>

<%--提示框--%>
<div class="" id="tipWindow" >
    <div class="gTips" ><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>

<script>
    setTimeout('$("#tipWindow").addClass("hidden")',2000);
</script>

</body>
</html>