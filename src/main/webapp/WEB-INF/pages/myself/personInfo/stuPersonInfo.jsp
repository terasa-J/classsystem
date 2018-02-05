<%--
  User: Jiang Jiahong
  Date: 2018/1/4
  Time: 16:47
  Description:"我"板块 —— “个人资料” 板块
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
    <script src="../js/footerChange.js"></script>

    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background: rgb(236, 236, 236);">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="page-inner" id="page-main-view">
    <form id="backForm" action="myself" method="post">
        <header style="background-color:#464646">
            <a href="javascript:document:backForm.submit();" id="setinback" class="icon-back">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36">个人资料</h3>
        </header>
    </form>

    <div id="secondmenu" class="hide"></div>
    <div class="mainView workspace">
        <link type="text/css" href="../css/myself/setting-1ab028fe81.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/myself/cropper.min.css">
        <div class="settingwrap" style="margin-bottom:30px;">
            <div class="set-in" id="set-in">
                <div class="content">

                    <a href="setHeadImg" title="点击设置头像">
                        <div class="face-change" id="fileElem">
                            <p class="fs30 fl">头像</p>
                            <div class="img fr">
                                <img src="<%=basePath%>${headimg}">
                            </div>

                        </div>
                    </a>

                    <div class="weui_cells weui_cells_access">

                        <a class="weui_cell" href="javascript:return false;" onclick="return false;"
                           style="cursor: default;">
                            <div class="weui_cell_bd weui_cell_primary">
                                <p class="fs30">姓名</p>
                            </div>
                            <div class=" fs30" style="color: #888;padding-right: 10px">${name}</div>
                        </a>

                        <a class="weui_cell" href="javascript:return false;" onclick="return false;"
                           style="cursor: default;">
                            <div class="weui_cell_bd weui_cell_primary">
                                <p class="fs30">班级</p>
                            </div>
                            <div class=" fs30" style="color: #888;padding-right: 10">${classNo}</div>
                        </a>

                        <a class="weui_cell" href="javascript:return false;" onclick="return false;"
                           style="cursor: default;">
                            <div class="weui_cell_bd weui_cell_primary">
                                <p class="fs30">学号</p>
                            </div>
                            <div class=" fs30" style="color: #888;padding-right: 10">${userID}</div>
                        </a>

                    </div>
                    <div class="weui_cells weui_cells_access">
                        <a class="weui_cell" id="major--change" href="javascript:return false;" onclick="return false;"
                           style="cursor: default;">
                            <div class="weui_cell_bd weui_cell_primary">
                                <p class="fs30">专业</p>
                            </div>
                            <div class=" fs30" style="color: #888;padding-right: 10">${major}</div>
                        </a>
                        <a class="weui_cell" id="school-change" href="javascript:return false;" onclick="return false;"
                           style="cursor: default;">
                            <div class="weui_cell_bd weui_cell_primary">
                                <p class="fs30">学校</p>
                            </div>
                            <div class=" fs30" style="color: #888;padding-right: 10">${school}</div>
                        </a>
                        <a class="weui_cell" id="role-change" href="javascript:return false;" onclick="return false;"
                           style="cursor: default;">
                            <div class="weui_cell_bd weui_cell_primary">
                                <p class="fs30">身份</p>
                            </div>
                            <div class="fs30" style="color: #888;padding-right: 10">学生</div>
                        </a>

                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 底部信息栏 -->

    <footer class="fs24 footmenu">

        <a id="classA" onFocus="clickClass()" onblur="unClickClass()" href="javascript:;">
            <div class="navSelf">
                <i class="iconfont bold">
                    <img onfocus=this.blur() id="imgClass"
                         src="../img/common/myClass1.png" style="vertical-align:middle;text-align:center">
                </i>
                <span>课堂</span>
            </div>
        </a>


        <a id="myselfA" onFocus="clickmyself()" onBlur="unClickMyself()" href="javascript:;">
            <div class="navSelf">
                <em class="dot red meDot hide2"></em>
                <i class="iconfont bold">
                    <img onfocus=this.blur() id="imgMyself" src="../img/common/myself2.png"
                         style="vertical-align:middle;text-align:center"></i>
                <span>我</span>
            </div>
        </a></footer>

</div>

<%--提示框--%>
<div class="" id="tipWindow" >
    <div class="gTips" ><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>

</body>
</html>
<script>
    setTimeout('$("#tipWindow").addClass("hidden")',3000);
</script>