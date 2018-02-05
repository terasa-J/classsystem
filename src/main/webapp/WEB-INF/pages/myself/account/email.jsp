<%--
  User: Jiang Jiahong
  Date: 2018/1/4
  Time: 17:46
  Description:"我"板块 —— “帐号” 板块 —— “邮箱设置”板块
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
</div>

<div class="page-inner page-fixed hidden" id="page-1511082508979" style="background-color:#ececec"></div>

<div class="page-inner page-fixed" id="page-1511082509946" style="background-color:#ececec">
    <form id="backForm" action="account" method="post">
        <header class="header-item" style="background-color:#464646">
            <a href="javascript:document:backForm.submit();" class="icon-back">
                <img src="../../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">邮箱</h3>
        </header>
    </form>
    <div class="page-auto absolute">

        <div class="weui_msg">
            <div class="weui_icon_area"><i class="weui_icon_success weui_icon_msg"></i>
                <img src="../../img/myself/email.png">
            </div>
            <div class="weui_text_area">
                <p class="weui_msg_desc fs32">当前邮箱：${email}</p>
            </div>
            <div class="weui_opr_area">
                <p class="weui_btn_area">
                <form id="changeEmailForm" action="changeEmail" method="post">
                    <a href="javascript:document:changeEmailForm.submit();" id="updateyx"
                       class="weui_btn weui_btn_blue fs32">更换邮箱</a>

                    <a onclick="unbindEmail()" href="#" class="weui_btn weui_btn_default fs32">解绑</a>
                </form>
                </p>
            </div>
        </div>

        <!-- 点击解绑，弹出消息框 -->
        <div class="hidden" id="unbindEmail">
            <div class="confirm popDialogArea" id="confirm-1511085963162" style="display:block">
                <div class="contentc">
                    <h3 class="title fs30 fswb">是否要解绑邮箱？</h3>
                    <p class="info fs28">解绑邮箱后，您将无法再使用该邮箱找回密码</p>
                    <form id="unbindFrom" action="confirmUnbindEmail" method="post">
                        <div class="opt">
                            <a href="javascript:;" onclick="canelUnbind()" class="btn canel">取消</a>
                            <a href="javascript:document:unbindFrom.submit();" class="btn sure">确定</a>
                            unbindEmail
                        </div>
                    </form>
                </div>
            </div>
            <div class="pop-bg isDel" id="isDel-1511085963162" style="display:block"></div>
        </div>

    </div>
    <!-- 提示框 -->
    <div id="tipWindow">
        <div class="gTips"><span style="background-color: #EA3640">${tipInfo}</span></div>
    </div>

</div>

<!-- “解绑”按钮的脚本 -->
<script type="text/javascript">
    function unbindEmail() {
        $("#unbindEmail").removeClass("hidden");
    }

    /*取消解绑*/
    function canelUnbind() {
        $("#unbindEmail").addClass("hidden");
    }

    setTimeout('$("#tipWindow").addClass("hidden")', 2000);
</script>

</body>
</html>