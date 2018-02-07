<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 16:13
  Description: 创建考勤 —— 开始考勤
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
    <link type="text/css" href="../css/teacher/attence-bfcbfa92f4.css" rel="stylesheet">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }

    .confirm, .pop-bg {
        position: absolute !important;
    }</style>
</head>
<body style="background: rgb(233, 241, 243);">

<div class="page-inner page-fixed" id="page-1510890702241" style="background-color:#e9f1f3">
    <header class="header-item" style="background-color:#00758e">
        <a  href="javascript:return false;" onclick="return false;"
            style="cursor: default;" class="icon-back" title="无法后退，请使用底部按钮退出!">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <%--考勤名称--%>
        <h3 class="fs36 text-overflow">${name}</h3>
    </header>
    <div class="page-auto absolute">
        <div class="content">
            <div class="number-box">
                <%--数字考勤码--%>
                <c:forEach items="${listCode}" var="listCode">
                    <span>${listCode}</span>
                </c:forEach>
            </div>
            <div class="number-opt clearfix">
                <span class="f1" style="font-size: 18px">老师请把上面数字告诉学生</span>
                <li/>
                <span class="f1" style="font-size: 18px">学生通过以上数字完成数字签到 </span>
            </div>
        </div>
        <div class="bottomfix">
            <div class="sign-count ">
                <%--显示时间--%>
                <i id="time" class="f1" style="font-size: 25px"></i>

            </div>
            <div class="bofixgroup">
                <a href="javascript:;" class="giveup" onclick="dropAttendance()">放弃</a>
                <a href="javascript:;" class="end" onclick="endAttendance()">结束</a>
            </div>
        </div>
    </div>
</div>

<!-- 放弃考勤 -->
<div id="dropAttendanceView" class="hidden">
    <div class="confirm popDialogArea" id="confirm-1511685042048" style="display:block">
        <div class="contentc">
            <h3 class="title fs30 fswb">放弃此次考勤？</h3>
            <p class="info fs28">放弃考勤后，此考勤数据将清零</p>
            <div class="opt">
                <form action="confirmDropAttendance" method="post" id="confirmDropAttendanceFrom">
                    <input type="hidden" name="courseId" value="${courseId}">
                    <input type="hidden" name="sirId" value="${sirId}">
                    <a href="javascript:;" class="btn canel" onclick="cancelDrop()">取消</a>
                    <a href="javascript:document:confirmDropAttendanceFrom.submit();" class="btn sure">确定</a>
                </form>
            </div>
        </div>
    </div>
    <div class="pop-bg isDel" id="isDel-1511685042048" style="display:block"></div>
</div>
</div>


<!-- 结束考勤 -->
<div class="hidden" id="endAttendanceView">
    <div class="confirm popDialogArea" id="confirm-1510891152660" style="display:block">
        <div class="contentc">
            <h3 class="title fs30 fswb">结束并完成考勤？</h3>
            <p class="info fs28">考勤结束后，老师可查看学生考勤状态</p>
            <div class="opt">
                <form action="endAttendance" method="post" id="endAttendanceForm">
                    <input type="hidden" name="courseId" value="${courseId}">
                    <input type="hidden" name="sirId" value="${sirId}">

                    <a href="javascript:;" class="btn canel" onclick="canelEndAttendance()">取消</a>
                    <a href="javascript:document:endAttendanceForm.submit();" class="btn sure">确定</a>
                </form>
            </div>
        </div>
    </div>
    <div class="pop-bg isDel" id="isDel-1510891152660" style="display:block"></div>
</div>
</div>

<!-- 结束 按钮 ————> 确定 提示信息框 -->
<div class="hidden" id="confirmEndView">
    <div class="gTips" id="show-tip"><span>考勤已结束</span></div>
</div>

<!-- 脚本信息 -->
<script type="text/javascript">
    window.onload = function () {
        getRTime();
    }

    function getRTime() {
        var nowTime = new Date();
        var y = nowTime.getFullYear();
        var m = nowTime.getMonth() + 1;
        var day = nowTime.getDate();
        var hh = nowTime.getHours();
        hh = checkTime(hh);
        var mm = nowTime.getMinutes();
        mm = checkTime(mm);
        var ss = nowTime.getSeconds();
        ss = checkTime(ss);
        document.getElementById("time").innerHTML = y + "年" + m + "月" + day + "日&nbsp;&nbsp;&nbsp;" + hh + ":" + mm + ":" + ss;
        setTimeout(getRTime, 500);
    }

    function checkTime(i) {
        if (i < 10) {
            i = "0" + i;
        }
        return i;
    }


    /*放弃 按钮*/
    function dropAttendance() {
        $("#dropAttendanceView").removeClass("hidden");
    }

    /*放弃 按钮 ————> 取消*/
    function cancelDrop() {
        $("#dropAttendanceView").addClass("hidden");
    }


    /*结束 按钮*/
    function endAttendance() {
        $("#endAttendanceView").removeClass("hidden");
    }

    /*结束 按钮 ————>取消*/
    function canelEndAttendance() {
        $("#endAttendanceView").addClass("hidden");
    }

    /*结束 按钮 ————>确认*/
    function confirmEndAttendance() {
        canelEndAttendance();
        $("#confirmEndView").removeClass("hidden");
        setTimeout('$("#confirmEndView").addClass("hidden")', 1000);
    }
</script>
</body>
</html>