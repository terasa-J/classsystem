<%--
  User: Jiang Jiahong
  Date: 2018/1/4
  Time: 17:39
  Description:"我"板块 —— “帐号” 板块
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
    <link type="text/css" href="../../css/common/common-9baddc8954.css" rel="stylesheet">
    <link href="../../css/common/layer.css" rel="stylesheet" type="text/css">
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
<body style="background-color: rgb(236, 236, 236);">
<div class="page-inner hidden" id="page-main-view">
    <header style="background-color:#464646">
        <div class="title fs36">我</div>
    </header>
    <div id="secondmenu" class="hide"></div>
    <div class="mainView workspace">
        <link type="text/css" href="../../css/myself/setting-1ab028fe81.css" rel="stylesheet">
    </div>
</div>

<div class="page-inner page-fixed" id="page-1510890334454" style="background-color:#ececec">
    <form id="backForm" action="myself" method="post">
        <header class="header-item" style="background-color:#464646">
            <a href="javascript:document:backForm.submit();" class="icon-back">
                <img src="../../img/common/backWhite.png" style="vertical-align:middle;text-align:center">
            </a>

            <i class="line"></i>
            <h3 class="fs36 text-overflow">账号</h3>
        </header>
    </form>
    <div class="page-auto absolute">
        <div class="weui_cells">
            <div class="weui_cell">
                <div class="weui_cell_bd weui_cell_primary">
                    <p class="fs30">账号</p>
                </div>
                <div class="weui_cell_ft gray170 fs30">${userID}</div>
            </div>
        </div>
        <div class="weui_cells weui_cells_access">
            <form id="emailForm" action="email" method="post">
                <a class="weui_cell" id="yxsetting" href="javascript:document:emailForm.submit();">
                    <div class="weui_cell_bd weui_cell_primary">
                        <p class="fs30">邮箱</p>
                    </div>
                    <div class="weui_cell_ft fs30">${email}</div>
                </a>
            </form>
            <a class="weui_cell" id="mmsetting" href="setPassword">
                <div class="weui_cell_bd weui_cell_primary">
                    <p class="fs30">密码</p>
                </div>
                <div class="weui_cell_ft fs30">******</div>
            </a>
        </div>
        <div class="weui_cells">
            <div class="exit-self">
                <a onclick="logOut()" href="javascript:;" class="fs32">退出登录</a>
            </div>
        </div>
    </div>

    <!-- 点击退出登录 弹出框 -->
    <div class="hidden" id="logOut">
        <div class="confirm popDialogArea" id="confirm-1510890360155" style="display:block">
            <div class="contentc">
                <h3 class="title fs30 fswb">确认登出此账号?</h3>
                <p class="info fs28"></p>
                <div class="opt">
                    <a onclick="cancleLogOut()" href="javascript:;" class="btn canel">取消</a>
                    <a href="home" class="btn sure">确定</a>
                </div>
            </div>
        </div>
        <div class="pop-bg isDel" id="isDel-1510890360155" style="display:block"></div>
    </div>
    <!-- 提示框 -->
    <div id="tipWindow">
        <div class="gTips"><span style="background-color: #EA3640">${tipInfo}</span></div>
    </div>
</div>
<!-- 点击退出登录 脚本 -->
<script type="text/javascript">
    function logOut() {
        $("#logOut").removeClass("hidden");
    }

    /*取消 退出登录*/
    function cancleLogOut() {
        $("#logOut").addClass("hidden");
    }

    setTimeout('$("#tipWindow").addClass("hidden")', 3000);

</script>

</body>
</html>