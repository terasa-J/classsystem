<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 14:35
  Description:“学生”板块 —— 点击“课堂”—— 课堂签到 板块
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
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner" id="page-stuCourse-attend">
    <link type="text/css" href="../css/student/stuCourse-06127df797.css" rel="stylesheet">


    <header class="header-item" style="background-color: rgb(0,117,142);">
        <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow" id="coursename">${studentCourseInfo.cname}</h3>

    </header>


    <!-- 抬头栏 -->
    <nav class="coursenav fs30" style="background-color: rgb(0,117,142);">
        <a href="javascript:;" class="active">课堂考勤</a>
        <a href="stuNoticePage?courseId=${studentCourseInfo.courseid}&index=${index}" class="">教师公告</a>

    </nav>


    <!-- 现在考勤 -->

    <div class="send-an">
        <a href="gotoNumberAttendance?sirId=${studentCourseInfo.sirid}&courseId=${studentCourseInfo.courseid}&index=${index}"
           id="publish-topic">
            <i class="iconfont fs28">
                <img src="../img/common/attend.png" style="vertical-align: middle;text-align: center;">
            </i>
            <span class="fs26" style=" white-space: nowrap;display: inline-block; ">现在去考勤</span>
        </a>
    </div>


    <div class="content workspace slideIn">

        <div class="total-box border-1px">
            <ul>
                <li>
                    <p>${attendNum}</p>
                    <h3 class="green">出勤</h3>
                </li>
                <li>
                    <p>${notAttendNum}</p>
                    <h3 class="red">缺勤</h3>
                </li>
                <li>
                    <p>${totalNum}</p>
                    <h3 class="blue">累计考勤</h3>
                </li>
            </ul>
        </div>
        <div class="total-detail">
            <ul>


                <c:forEach items="${courseAttendanceInfoList}" var="courseAttendanceInfoList" varStatus="status">
                    <li class="border-1px" data-id="MDAwMDAwMDAwMLOcrduGz6-v" data-title="2017.11.17" data-type="1">
                        <div class="name">
                            <h3 class="fs30 text-overflow">${courseAttendanceInfoList.name}</h3>
                            <p class="fs24">考勤时间 : ${courseAttendanceInfoList.attendtime} </p>
                        </div>
                        <div class="state">
                            <span class="green fs28 seeall">出勤</span>
                        </div>
                    </li>
                </c:forEach>

                <c:forEach items="${notAttendanceList}" var="notAttendanceList" varStatus="status">
                    <li class="border-1px" data-id="MDAwMDAwMDAwMLOcrduGz6ux" data-title="第一次考勤" data-type="0">
                        <div class="name">
                            <h3 class="fs30 text-overflow">${notAttendanceList.name}</h3>
                            <p class="fs24">考勤时间 :${notAttendanceList.createtime} </p>
                        </div>
                        <div class="state">

                            <span class="red fs28 seeall">旷课</span>

                        </div>
                    </li>
                </c:forEach>

            </ul>
        </div>
    </div>

</div>

</body>
</html>