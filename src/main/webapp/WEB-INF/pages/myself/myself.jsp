<%--
  User: Jiang Jiahong
  Date: 2018/1/22
  Time: 22:39
  Description:"我"这一板块
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
    <link type="text/css" href="../css/myself/setting-1ab028fe81.css" rel="stylesheet">
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
<body style="background-color: rgb(236, 236, 236);">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<div class="page-inner" id="page-main-view">
    <header style="background-color:#464646">
        <div class="title fs36">我</div>
    </header>

    <div class="mainView workspace">
        <div class="settingwrap" style="margin-bottom:30px;">
            <div class="set-out" id="set-out">
                <div class="content">
                    <form id="infoForm" action="personInfo" method="post">
                        <div class="face-box">
                            <a class="weui_cell" href="javascript:document:infoForm.submit();"
                               style="margin-right: 180px;">
                                <div class="img">
                                    <img src="<%=basePath%>${user.headimg}" id="face">
                                </div>
                                <div class="face-info">
                                    <h3 class="fs32">
                                        <b class="text-overflow">${user.name}</b>
                                    </h3>
                                    <p class="text-overflow fs28">学校：${user.school}</p>
                                </div>
                            </a>
                        </div>
                    </form>

                    <form id="accountForm" action="account" method="post">
                        <div class=" weui_cells weui_cells_access fs30">
                            <a class="weui_cell" href="javascript:document:accountForm.submit();">
                                <div class="weui_cell_hd">
                                    <i class="iconfont blue fs32">
                                        <img src="../img/myself/account.png"
                                             style="vertical-align: middle;text-align: center;padding-left:30px">
                                    </i>
                                </div>
                                <div class="weui_cell_bd weui_cell_primary">
                                    <p style="padding-left:4%">账号</p>
                                </div>
                                <div class="weui_cell_ft" style="padding-right: 20px"></div>
                            </a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <!-- 底部信息栏 -->
    <form id="userClassForm" action="getUserCoursePage" method="post">
        <footer class="fs24 footmenu">
            <a id="classA" onFocus="clickClass()" onblur="unClickClass()" href="javascript:document:userClassForm.submit();">
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
            </a>
        </footer>
    </form>

</div>

</body>
</html>