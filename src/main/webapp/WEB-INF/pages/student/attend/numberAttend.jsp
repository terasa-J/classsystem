<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 14:45
  Description:“学生”板块 —— 点击“课堂”—— 课堂签到 板块 —— 数字签到
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
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
    <link type="text/css" href="../css/student/stuCourse-06127df797.css" rel="stylesheet">
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
<div class="page-inner" id="page-checkin">
    <header class="header-item" style="background-color: rgb(0, 117, 142);">
        <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow" id="attencename">数字签到</h3>
        <!-- 要加事件判断 -->
        <button class="button fs30" onclick="goToWebAttendance()">完成</button>
    </header>
    <div class="content workspace gps-space hide" style="display: none;">
        <div class="opt clearfix">
            <span style="margin-top:100px">系统会自动帮您签到，请稍后...</span>
        </div>
    </div>
    <form action="gotoWebAttendance" method="post" id="gotoWebAttendanceForm">
        <div class="content checkinBox workspace">
            <div class="opt clearfix">
                <p>请输入4位数字，手动完成签到</p>
                <span>（数字由老师处获取，完成后还有GPS签到）</span>
            </div>
            <div class="number-box">
                <!--<input type="text" maxlength="4">-->
                <div class="vc-number">
                    <span class="vc-n-grid">
                        <span class="grid-item"></span>
                        <span class="grid-item"></span>
                        <span class="grid-item"></span>
                        <span class="grid-item"></span>
                    </span>
                    <input type="tel" name="attendanceCode" class="vc-n-input j_modalAuthInput" maxlength="4"
                           id="phoneVer_modalAuthInput">
                    <div class="vc-n-block"></div>
                </div>
            </div>
        </div>


        <!-- 当输入数字足够4位数字的时候弹出 -->
        <div class="hidden" id="alertWindow">
            <div class="weui_dialog_alert popDialogArea">
                <div class="weui_mask"></div>
                <div class="weui_dialog">
                    <div class="weui_dialog_hd">
                        <strong class="weui_dialog_title"></strong>
                    </div>
                    <div class="weui_dialog_bd">数字签到成功，请前往GPS定位签到！</div>
                    <div class="weui_dialog_ft">

                        <input type="hidden" name="sirId" value="${sirId}">
                        <input type="hidden" name="courseId" value="${courseId}">
                        <a href="javascript:;" class="weui_btn_dialog " onclick="cancel()" style="width: 20%">取消</a>
                        <a href="javascript:document:gotoWebAttendanceForm.submit()" class="weui_btn_dialog ">确定</a>
                        <input type="hidden" name="index" value="${index}">
                    </div>
                </div>
            </div>
        </div>
    </form>

   </div>
</body>

<%--提示框--%>
<div class="" id="tipWindow" >
    <div class="gTips" ><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>

</html>

<script>

    setTimeout('$("#tipWindow").addClass("hidden")', 2000);

    /*当输入4位数字后就弹出前往GPS签到*/
    function goToWebAttendance() {
        var vstr = document.getElementById("phoneVer_modalAuthInput").value;
        if (vstr.length == 4) {
            $("#alertWindow").removeClass("hidden");
        } else {
            alert("请输入正确4位签到码");
        }
    }

    function cancel() {
        $("#alertWindow").addClass("hidden");
    }


</script>