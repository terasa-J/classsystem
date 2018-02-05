<%--
  User: Jiang Jiahong
  Date: 2018/1/4
  Time: 17:42
  Description:"我"板块 —— “帐号” 板块 —— “密码设置”板块
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
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background-color: rgb(236, 236, 236);">
<div class="page-inner page-fixed" id="page-1511098831923" style="background-color:#ececec">
    <form action="resetPassword" method="post">
        <header class="header-item" style="background-color:#464646">
            <a href="javascript:;" onclick="javascript :history.back(-1);" class="icon-back">
                <img src="../../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">密码设置</h3>
            <input type="submit" value="保存" class="button fs28">
        </header>

        <div class="page-auto absolute">
            <div class="weui_cells weui_cells_form">
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs30">旧密码</label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                        <input id="oldPass" class="weui_input fs30" type="password" name="oldPass" placeholder="旧密码验证"
                               autofocus>
                    </div>
                </div>
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs30">新密码</label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                        <input id="newPass" class="weui_input fs30" type="password" name="newPass" placeholder="新密码">
                    </div>
                </div>
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs30">确认密码</label></div>
                    <div class="weui_cell_bd weui_cell_primary">
                        <input id="newPassConfirm" class="weui_input fs30" type="password" name="newPassConfirm"
                               placeholder="新密码确认">
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
</body>

<script>
    $("#oldPass").blur(checkOldPass);
    $("#newPass").blur(checkNewPass);
    $("#newPassConfirm").blur(checkNewPassConfirm);

    setTimeout('$("#tipWindow").addClass("hidden")', 3000);

    //验证密码   8-12位字符
    function checkOldPass() {
        var oldPass = $("#oldPass").val();
        var regPassword = /^.{8,12}$/;
        var isPassword = regPassword.test(oldPass);
        if (isPassword == false) {
            $("#tipWindow").removeClass("hidden");
            $(".gTips span").text("请输入8-12位密码");
            setTimeout('$("#tipWindow").addClass("hidden")', 3000);
        }
    }

    //验证密码   8-12位字符
    function checkNewPass() {
        var newPass = $("#newPass").val();
        var regPassword = /^.{8,12}$/;
        var isPassword = regPassword.test(newPass);
        if (isPassword == false) {
            $("#tipWindow").removeClass("hidden");
            $(".gTips span").text("请设置8-12位新密码");
            setTimeout('$("#tipWindow").addClass("hidden")', 3000);
        }
    }

    //验证2次输入密码是否一致
    function checkNewPassConfirm() {
        var newPass = $("#newPass").val();
        var newPassConfirm = $("#newPassConfirm").val();
        //判断是否为空
        if (newPass.length == 0 || newPassConfirm.length == 0) {
            $("#tipWindow").removeClass("hidden");
            $(".gTips span").text("输入密码不能为空");
            setTimeout('$("#tipWindow").addClass("hidden")', 3000);
        }
        if (newPassConfirm != newPass) {
            $("#tipWindow").removeClass("hidden");
            $(".gTips span").text("两次输入密码不一样");
            setTimeout('$("#tipWindow").addClass("hidden")', 3000);
        }
    }
</script>

</html>