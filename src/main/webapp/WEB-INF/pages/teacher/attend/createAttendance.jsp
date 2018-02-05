<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 16:08
  Description: 创建新 考勤
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
    <link type="text/css" href="../css/teacher/attence-bfcbfa92f4.css" rel="stylesheet">
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

<div class="page-inner page-fixed" id="page-1510890671700" style="background-color:#e9f1f3">
    <header class="header-item" style="background-color:#00758e">
        <a href="javascript:history.back(-1)" class="icon-back">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow">新建考勤</h3>
    </header>
    <div class="page-auto absolute">
        <form id="confirmCreateAttendance" action="confirmCreateAttendance" method="post">
            <div class="content edit-box" id="attend" data-type="1">
                <h3 class="att-title fs30">考勤名称</h3>
                <div class="input-box">
                    <div class="border-1px">
                        <input type="text" placeholder="${name}" name="name" id="name" autofocus>
                    </div>
                </div>
                <h3 class="att-title fs30">应到人数</h3>
                <div class="input-box">
                    <div class="border-1px">
                        <input type="text" placeholder="请输入阿拉伯数字" name="actualNumber" id="actualNumber" autofocus>
                    </div>
                </div>
                <h3 class="att-title fs30">默认考勤方式</h3>
                <div class="way">
                    <a href="javascript:return false;" onclick="return false;" style="cursor: default;" class="fl ">
                        <img src="../img/teacher/szkq.png">
                        <span>数字考勤</span>
                    </a>
                    <a href="javascript:return false;" onclick="return false;" style="cursor: default;" class="fl ">
                        <img src="../img/teacher/and.png">

                    </a>
                    <a href="javascript:return false;" onclick="return false;" style="cursor: default;" class="fl">
                        <img src="../img/teacher/ctkq.png">
                        <span>GPS考勤</span>
                    </a>
                </div>
                <input type="hidden" name="courseId" value="${courseId}">
                <a href="javascript:;" class="goto-attend fs30  " id="clickCreate">创建考勤</a>

            </div>
        </form>
    </div>
</div>
</body>
</html>


<script>
    $("#name").blur(judge);
    $("#actualNumber").blur(judge);

    function judge() {
        var name = $("#name").val();
        var actualNumber = $("#actualNumber").val();
        if (name && actualNumber) {
            $("#clickCreate").addClass("active");
            $("#clickCreate").attr("href", "javascript:document:confirmCreateAttendance.submit()");
        } else {
            $("#clickCreate").removeClass("active");
            $("#clickCreate").attr("href", "javascript:;");
        }
    }

</script>
