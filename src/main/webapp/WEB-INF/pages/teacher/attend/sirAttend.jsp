<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 16:03
  Description: 教师考勤 板块
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
    </style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner" id="page-checkword-index">
    <header class="header-item" style="background-color: rgb(0,117,142);">
        <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow" id="coursename">${course.cname}</h3>

    </header>


    <!-- 抬头栏 -->
    <nav class="coursenav fs30" style="background-color: rgb(0,117,142);">
        <a href="javascript:;" class="active">课堂考勤</a>
        <a href="noticePage?courseid=${course.courseid}&cname=${course.cname}&index=${index}" class="">教师公告</a>

    </nav>

    <div class="mainView workspace">
        <div class="notice-list-container">
            <div class="content">
                <!-- 创建新的考勤 -->
                <div class="send-an" style="margin-bottom: 2%;">
                    <a href="createAttendance?courseId=${course.courseid}&name=${course.cname}" id="publish-topic">
                        <i class="iconfont fs28">
                            <img src="../img/common/attend.png" style="vertical-align: middle;text-align: center;">
                        </i>
                        <span class="fs26" style=" white-space: nowrap;display: inline-block; ">创建新考勤</span>
                    </a>

                </div>

                <ul id="topic-lists" class="notice-lists" >
                    <c:forEach items="${attendanceList}" var="attendanceList">
                        <!-- 考勤信息 -->
                        <div id="wrapper" class="workspace">
                            <div class="attendance-list">
                                <ul>
                                    <li class="border-1px" data-id="MDAwMDAwMDAwMLOcrduGz6ux">
                                            <%--点击每一个详情--%>
                                        <a href="attendanceDetail?attendanceId=${attendanceList.attendanceid}&courseId=${course.courseid}"
                                           class="link"></a>
                                        <div class="attence-cont">
                                            <div class="title">
                                                <h3 class="fs30 text-overflow">${attendanceList.name}</h3>
                                            </div>
                                            <div class="rate fs24" style="padding-top: 10px">
                                                <span class="text-overflow">
                                                      考勤时间 : ${attendanceList.createtime}
                                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                                    应到 : ${attendanceList.actualnumber}人
                                                </span>
                                            </div>
                                        </div>
                                        <i class="fs32">〉</i>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
<%--提示框--%>
<div id="tipWindow">
    <div class="gTips" id="show-tip"><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>

</body>
</html>

<script>
    /*提示框显示时间*/
    setTimeout('$("#tipWindow").addClass("hidden")', 2000);
</script>