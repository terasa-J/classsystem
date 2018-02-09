<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 13:10
  Description: “学生”板块 —— 课堂 首页
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
    <link type="text/css" href="../css/student/course-d13d9e5a0c.css" rel="stylesheet">
    <script src="../js/footerChange.js"></script>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }

    .confirm, .pop-bg, .weui_mask_transition, .weui_actionsheet {
        position: absolute !important;
    }</style>
</head>
<body style="background-color: rgb(236, 236, 236);" onload="toFocusClassA()">

<div class="page-inner" id="page-main-view">
    <header style="background-color:#464646">
        <h2 class="fs36">课堂</h2>
        <a href="attendClass" class="fs30 c-btn banji">加入班级</a>
    </header>

    <div class="mainView workspace">
        <div id="host-box">
            <div class="content" id="null-div">
                <div class="ktcon1r">
                    <ul>
                        <li id="sortcourse" class="ktli1">金院课堂，趣味签到</li>
                    </ul>

                    <!-- 加入你的第一个课程  图片 -->
                    <div class="upperRightCorner nullPage" style="padding-top:0">
                        <span class="icon-corner"></span>
                        <p class="fs30">点击加入你的第一个课程吧！</p>
                        <span class="icon-bg-course"></span>
                    </div>
                </div>

                <c:forEach items="${stuCourseList}" var="stuCourse" varStatus="status">
                    <!-- 获得班级信息列表 2017.11.20-->
                    <ul class="course-main-list" id="course-list">
                        <li style="background-color:#07352b;background-image:url(../img/student/bgList.jpg)"
                            data-id="MDAwMDAwMDAwMLOGvZSH36dr" data-invite="BWTUSL" data-role="0">
                                <%--进入详细班级信息--%>
                            <form action="stuAttend" method="post" id="stuAttendForm${status.index}">
                                <input type="hidden" name="index" value="${status.index}">
                                <a href="javascript:document:stuAttendForm${status.index}.submit();"
                                   id="${status.index}" class="link"
                                   data-bg="#e9f4f0" data-banner="#07352b"></a>
                            </form>

                            <div class="title clearfix">
                                <h3 class="fs36 text-overflow">${stuCourse.cname}</h3>
                                <div class="opt-btn">
                                <span class="iconfont fs40">
                                    <img src="../img/student/more.png" id="${stuCourse.courseid}"
                                         name="${stuCourse.cname}" onclick="showClassMore(this)">
                                </span>
                                </div>
                            </div>
                            <div class="total">
                                <div class="yqm">
                                    <p class="fs28 text-overflow">老师：${stuCourse.name}</p>
                                </div>
                            </div>
                            <span class="fs28 " style="color: #fff">加入时间：${stuCourse.attendtime}</span>

                        </li>
                    </ul>

                    <!-- 点击更多 显示的界面 2017.11.20 -->
                    <div class="hidden" id="moreClassInfo">
                        <div class="actionSheetWrapArea" id="actionSheet_wrap_1511166999864">
                            <div class="weui_mask_transition weui_fade_toggle" id="mask"
                                 style="display: block;"></div>
                            <div class="weui_actionsheet fs30 weui_actionsheet_toggle" id="weui_actionsheet">
                                <div class="weui_actionsheet_menu">
                                    <div class="weui_actionsheet_cell" onclick="quitClassView()">退出班级</div>
                                </div>
                                <div class="weui_actionsheet_action">
                                    <div class="weui_actionsheet_cell" id="actionsheet_cancel"
                                         onclick="hideClassMore()">取消
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>

            </div>
        </div>
    </div>


    <!-- 退出班级 -->
    <div id="quitClass" class="hidden">
        <div class="confirm popDialogArea" id="confirm-1511175754178" style="display:block">
            <div class="contentc">
                <h3 class="title fs30 fswb">确定退出&nbsp;&nbsp;"<span class="text-overflow" id="quitCourseSpan">课堂</span>"&nbsp;&nbsp;么？
                </h3>
                <p class="info fs28">您在这个班级的任何信息或评论将被永久删除<br><span class="red">警告：此操作无法撤销</span></p>

                <div class="opt">
                    <a href="javascript:;" class="btn canel" onclick="canelQuitClass()">取消</a>
                    <a href="javascript:;" id="confirmQuitCourse" class="btn sure" onclick="confirmQuitClass()">确定</a>
                </div>
            </div>
        </div>
        <div class="pop-bg isDel" id="isDel-1511175754178" style="display:block"></div>
    </div>


    <!-- 退出班级   确定信息栏 2017.11.20 -->
    <div class="hidden" id="quitClassSuccess">
        <div class="gTips" id="show-tip"><span>退出班级成功</span></div>
    </div>

    <!-- 底部信息栏 -->
    <form id="myselfForm" action="myself" method="post">
        <footer class="fs24 footmenu">
            <a id="classA" onfocus="clickClass()" onblur="unClickClass()" class="active" href="javascript:;">
                <div class="navSelf">
                    <i class="iconfont bold">
                        <img onfocus="this.blur()" id="imgClass" src="../img/common/myClass2.png"
                             style="vertical-align:middle;text-align:center">
                    </i>

                    <span>课堂</span>
                </div>
            </a>

            <a id="myselfA" onfocus="clickmyself()" onblur="unClickMyself()"
               href="javascript:document:myselfForm.submit();">
                <div class="navSelf">
                    <em class="dot red meDot hide2"></em>
                    <i class="iconfont bold">
                        <img onfocus="this.blur()" id="imgMyself" src="../img/common/myself1.png"
                             style="vertical-align:middle;text-align:center"></i>
                    <span>我</span>
                </div>
            </a>
        </footer>
    </form>
</div>

<%--提示框--%>
<div class="" id="tipWindow">
    <div class="gTips"><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>


<script>
    setTimeout('$("#tipWindow").addClass("hidden")', 2000);

    /*页面加载的时候，“课堂”按钮默认获焦*/
    function toFocusClassA() {
        $("#classA").focus();
    }

    /*点击班级更多*/
    function showClassMore(e) {
        $("#moreClassInfo").removeClass("hidden");

        var courseid = $(e).attr("id");
        var name = $(e).attr("name");

        //修改删除框中的班级名称
        $("#quitCourseSpan").text(name);
        //修改确定删除中的URL
        $("#confirmQuitCourse").attr("href", "confirmQuitCourse?courseid=" + courseid);
    }

    /*隐藏更多的界面*/
    function hideClassMore() {
        $("#moreClassInfo").addClass("hidden");
        clickClass();
    }

    /*退出班级 按钮*/
    function quitClassView() {
        $("#quitClass").removeClass("hidden");
        hideClassMore();
    }

    /*退出班级 按钮  --- 取消 按钮*/
    function canelQuitClass() {
        $("#quitClass").addClass("hidden");
    }

    /*退出班级 按钮  --- 确定 按钮*/
    function confirmQuitClass() {
        $("#quitClassSuccess").removeClass("hidden");
        canelQuitClass();
        setTimeout('$("#quitClassSuccess").addClass("hidden")', 1000);
    }

</script>

</body>
</html>