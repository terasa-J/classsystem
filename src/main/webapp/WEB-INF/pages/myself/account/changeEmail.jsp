<%--
  User: Jiang Jiahong
  Date: 2018/1/4
  Time: 17:51
  Description:"我"板块 —— “帐号” 板块 —— “邮箱设置”板块 ——“更换邮箱”板块
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
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/register.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background-color: rgb(236, 236, 236);">
<div class="page-inner hidden" id="page-main-view">
    <header style="background-color:#464646">
        <div class="title fs36">我</div>
    </header>

    <div id="secondmenu" class="hide"></div>
    <div class="mainView workspace">
        <link type="text/css" href="../../css/myself/setting-1ab028fe81.css" rel="stylesheet">
        <div class="settingwrap" style="margin-bottom:30px;">
            <div class="set-out" id="set-out">
            </div>
        </div>
    </div>
</div>


<div class="page-inner page-fixed" id="page-1511085354445" style="background-color:#ececec">
    <form id="changeEmail" action="confirmChangeEmail" method="post">
        <header class="header-item" style="background-color:#464646">
                <a href="javascript:;" onclick="javascript :history.back(-1);" class="icon-back">
                    <img src="../../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
                </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">更改邮箱</h3>
            <input type="submit" value="保存" class="button fs28">
        </header>
        <div class="page-auto absolute">
            <div class="weui_cells_title fs28">现有邮箱：${email}</div>
            <div class="weui_cells weui_cells_form">
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs30">新邮箱</label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                        <input id="email" class="weui_input fs30" type="email" name="email" placeholder="请输入新邮箱"
                               value="">
                    </div>
                </div>
            </div>
        </div>
    </form>
    <!-- 提示框 -->
    <div id="tipWindow">
        <div class="gTips"><span style="background-color: #EA3640">${tipInfo}</span></div>
    </div>
</div>
<script>
    $("#email").blur(checkEmail);
    setTimeout('$("#tipWindow").addClass("hidden")', 3000);
</script>
</body>
</html>