<%--
  User: Jiang Jiahong
  Date: 2017/12/28
  Time: 19:00
  Description: 忘记密码
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
    <link type="text/css" href="./css/common/common-9baddc8954.css" rel="stylesheet">
    <link type="text/css" href="./css/common/login-6cea13a674.css" rel="stylesheet">
    <link href="./css/common/layer.css" rel="stylesheet" type="text/css">
    <script src="./js/jquery-3.2.1.min.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body>
<form id="forgetPasswordForm" action="forgetPassword" method="post">
    <div class="page-inner" id="page-forget-pass">
        <header class="style2">
            <a href="/home" class="icon-back" data-pjax="">
                <img src="./img/common/backBlack.png" style="vertical-align:middle;text-align:center">
            </a>
            <i class="line"></i>
            <h3 class="fs36">忘记密码</h3>
        </header>

        <div class="content slideIn">
            <div class="weui_cells weui_cells_form kform withcancelform" style="margin-bottom:5%;">
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs32">账号</label></div>
                    <div class="weui_cell_bd weui_cell_primary input-div">
                        <input id="userID" class="weui_input fs32" type="email" name="userID" placeholder="学号/教师号"
                               autofocus>
                        <i class="cancel iconfont" style="display: none;"></i>
                    </div>
                </div>
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs32">身份</label></div>
                    <div class="weui_cell_bd weui_cell_primary  ">
                        <form method="post" action="" class="fs32 ">
                            <input type="radio" name="role" style="margin-right: 2%" value="student" >学生
                            <input type="radio" name="role" style="margin-left: 10%;margin-right: 2%" value="teacher">教师
                        </form>

                    </div>
                </div>
            </div>
            <div class="login-btn">
                <a href="javascript:;" class="log-btn fs32" id="nextClick">下一步</a>
            </div>
        </div>
    </div>
</form>

<%--提示框--%>
<div class="" id="tipWindow" >
    <div class="gTips" ><span style="background-color: #0C88E8">${tipInfo}</span></div>
</div>

<script>
    $("#userID").blur(checkUserID);

    //个人ID 学号 教师号 9位数字
    function checkUserID() {
        var userID = $("#userID").val();
        var reUserID = /^\d{9}$/;
        var isUserID = reUserID.test(userID);
        if (isUserID == false) {
            $("#nextClick").attr("href", "javascript:;");
            $("#tipWindow").removeClass("hidden");
            $(".gTips span").text("学号/教师号 输入格式有误");
            setTimeout('$("#tipWindow").addClass("hidden")', 3000);
            $(".log-btn").removeClass("active");
        }else{
            $("#nextClick").attr("href", "javascript:document:forgetPasswordForm.submit();");
            $(".log-btn").addClass("active");
        }
    }

</script>
</body>
</html>