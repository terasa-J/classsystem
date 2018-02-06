<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 16:16
  Description:  考勤 详细信息
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

    .cs-pop, .pop-bg, .weui_mask_transition, .weui_actionsheet {
        position: absolute !important;
    }</style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner" id="page-attence">

    <header class="header-item" style="background-color: rgb(0, 117, 142);">
        <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>

        <h3 class="fs36 text-overflow">${attendance.name}</h3>

        <div class="more fs30">
                <span class="iconfont fs36" onclick="moreInfo()">
                    <img src="../img/student/more.png" style="vertical-align: middle;text-align:center;">
                </span>
        </div>
    </header>
    <div id="wrapper" class="workspace">
        <div class="student-cont student-attence-cont">
            <ul class="rate-cont border-1px">
                <li data-state="-1">
                    <p class="text-overflow">${attendance.actualnumber}人</p>
                    <span class="blue">应到</span>
                </li>
                <li data-state="0">
                    <p class="text-overflow">${attendanceNum}人</p>
                    <span class="green">实到</span>
                </li>
                <li data-state="1">
                    <p class="text-overflow">${restNum}人</p>
                    <span class="red">缺勤</span>
                </li>
            </ul>
            <ul class="student-list attence-student-list">
                <c:forEach items="${stuAttendanceList}" var="stuAttendanceList">
                    <li class="border-1px" data-id="MDAwMDAwMDAwMLR2uaE">
                        <p class="stuid fs28 text-overflow">${stuAttendanceList.stuid}</p>
                        <p class="name text-overflow fs30">${stuAttendanceList.name}</p>
                        <%--<input type="text"  class="stuid fs28 " style="margin-right: 130px;max-width: 150px" value="${stuAttendanceList.location}">--%>
                        <a href="javascript:return false;" onclick="return false;"
                           style="cursor: default;" class="green fs30" data-state="0">出勤</a>
                    </li>
                </c:forEach>


                <c:forEach items="${notAttendStuList}" var="notAttendStuList">
                    <li class="border-1px" data-id="MDAwMDAwMDAwMLR2x6E">
                        <p class="stuid fs28 text-overflow">${notAttendStuList.stuid}</p>
                        <p class="name text-overflow fs30">${notAttendStuList.name}</p>
                        <a href="javascript:return false;" onclick="return false;"
                           style="cursor: default;" class="red fs30" data-state="1">旷课</a>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </div>
</div>


<!-- 右上角 的 三点 按钮 -->
<div class="hidden" id="moreInfoView">
    <div class="actionSheetWrapArea" id="actionSheet_wrap_1511688283142">
        <div class="weui_mask_transition weui_fade_toggle" id="mask" style="display: block;"></div>
        <div class="weui_actionsheet fs30 weui_actionsheet_toggle" id="weui_actionsheet">
            <div class="weui_actionsheet_menu">

                <a href="updateAttendance?attendanceId=${attendance.attendanceid}&attendanceName=${attendance.name}">
                    <div class="weui_actionsheet_cell" id="edit">编辑考勤命名</div>
                </a>
                <a href="exportEmail?attendanceId=${attendance.attendanceid}&courseId=${courseId}">
                <div class="weui_actionsheet_cell" id="gotogps" onclick="exportInfoSuccess()">导出考勤到邮箱</div>
                </a>
                <div class="weui_actionsheet_cell" id="del" onclick="deleteAttendance()">删除考勤</div>


            </div>
            <div class="weui_actionsheet_action">
                <div class="weui_actionsheet_cell" id="actionsheet_cancel" onclick="cancelMoreInfo()">取消</div>
            </div>
        </div>
    </div>
</div>



<!-- 删除 考勤 -->
<div class="hidden" id="deleteAttendanceView">
    <div class="cs-pop popDialogArea" id="cs-pop-1511689845576" style="display:block">
        <h3 class="title fs30 border-1px">确认删除此次考勤？</h3>
        <div class="opt">
            <a href="javascript:;" class="cancel fs30 " onclick="cancelDelete()">取消</a>
            <a href="confirmDelAttend?attendanceId=${attendance.attendanceid}" class="sure fs30 border-1px-left ">确定</a></div>
    </div>
    <div class="pop-bg isDel" style="display:block"></div>
</div>
</div>

<!-- 提示框 -->
<div class="" id="tipWindow">
    <div class="gTips" id="show-tip"><span>${tipInfo}</span></div>
</div>

<!-- 脚本信息 -->
<script type="text/javascript">
    setTimeout('$("#tipWindow").addClass("hidden")',2000);

    /*  右上角 的 三点 按钮 */
    function moreInfo() {
        $("#moreInfoView").removeClass("hidden");
    }

    /*  右上角 的 三点 按钮 ———— > 取消*/
    function cancelMoreInfo() {
        $("#moreInfoView").addClass("hidden");
    }

    /*右上角 的 三点 按钮 ———— > 导出  */
    function exportInfoSuccess() {
        cancelMoreInfo();
        $("#exportInfo").removeClass("hidden");
        setTimeout('$("#exportInfo").addClass("hidden")', 1000);
    }

    /*右上角 的 三点 按钮 ———— > 删除  */
    function deleteAttendance() {
        $("#deleteAttendanceView").removeClass("hidden");
        cancelMoreInfo();
    }

    /*右上角 的 三点 按钮 ———— > 删除  ———— > 取消*/
    function cancelDelete() {
        $("#deleteAttendanceView").addClass("hidden");
    }


</script>

</body>
</html>