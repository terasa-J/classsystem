<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 16:24
  Description: 编辑考勤 信息
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>课堂派</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Cache" content="no-cache">
    <link type="text/css" href="../css/common/common-9baddc8954.css" rel="stylesheet">
    <link href="../css/common/layer.css" rel="stylesheet" type="text/css">
    <link type="text/css" href="../css/teacher/attence-bfcbfa92f4.css" rel="stylesheet">
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner page-fixed" id="page-1511689171303" style="background-color:#e9f1f3">
    <form action="confirmUpdateAttendance" method="post">
        <header class="header-item" style="background-color:#00758e">
            <a href="javascript:history.back(-1);" class="icon-back">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">编辑考勤</h3>
            <input type="submit" value="保存" class="button fs30">
        </header>
        <div class="page-auto absolute">
            <div class="content edit-box" id="attend">
                <h3 class="att-title fs30">考勤名称</h3>
                <div class="input-box">
                    <div class="border-1px">
                        <input type="text" placeholder="${attendanceName}"  name="attendanceName" autofocus="">
                        <input type="hidden" value="${attendanceId}" name="attendanceId">
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>


<!-- 保存 按钮 提示信息框 -->
<div class="hidden" id="confirmEndView">
    <div class="gTips" id="show-tip"><span>修改成功</span></div>
</div>


</body>
</html>
