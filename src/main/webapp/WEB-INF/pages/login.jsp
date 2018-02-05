<%--
  User: Jiang Jiahong
  Date: 2017/12/26
  Time: 16:17
  Description: 登录界面
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
    <link href="./css/login/layer.css" rel="stylesheet" type="text/css">
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

<div class="page-inner" id="page-login">
    <div class="content" style="height:100%;position:relative;min-height:480px;padding-top:0;">
        <form id="loginForm" action="login" method="post">
        <div class="user-avatar">
            <img src="./img/common/defaultHead.jpg" alt="">
        </div>
        <div class="weui_cells weui_cells_form kform withcancelform loginform" style="margin-top:0;margin-bottom:5%;">
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">账号</label></div>
                <div class="weui_cell_bd weui_cell_primary emailphone input-div">
                    <input id="username" class="weui_input fs32" type="text" name="userID" placeholder="学号/教师号" autofocus>

                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">密码</label></div>
                <div class="weui_cell_bd weui_cell_primary input-div">
                    <input id="password" class="weui_input fs32" type="password" name="password" placeholder="密码"
                           minlength="6" maxlength="30">

                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">身份</label></div>
                <div class="weui_cell_bd weui_cell_primary  ">
                    <form method="post" action="" class="fs32 ">
                        <input type="radio"  name="role" style="margin-right: 2%;" value="student" checked>学生
                        <input type="radio" name="role" style="margin-left: 10%;margin-right: 2%" value="teacher">教师
                    </form>

                </div>
            </div>
        </div>
        <%--角色--%>
        <div class="login-btn">
            <a href="javascript:document:loginForm.submit();" class="log-btn fs32">登录</a>
            <a class="message-login-btn fs28 blue">&nbsp;</a>
            <a href="/forgetPassword" class="forget-btn fs24 gray130" data-pjax="">忘记密码？</a>
        </div>
        <a href="/register/registerHome" class="regist-btn fs32" >注册</a>
        </form>
    </div>
</div>


<%--提示框--%>
<div class="" id="tipWindow" >
    <div class="gTips" ><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>


<script>
    $("#username").blur(judge);
    $("#password").blur(judge);

    function judge() {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username && password) {
            $(".log-btn").addClass("active");
        } else {
            $(".log-btn").removeClass("active");
        }
    }
    setTimeout('$("#tipWindow").addClass("hidden")',2000);
</script>

</body>
</html>
