<%--
  User: Jiang Jiahong
  Date: 2017/12/26
  Time: 17:21
  Description:教师注册
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
    <link type="text/css" href="../css/common/login-6cea13a674.css" rel="stylesheet">
    <link href="../css/common/layer.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/register.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body>

<header class="style2">
    <a href="/register/registerHome" class="icon-back" data-pjax="">
        <img src="../img/common/backBlack.png" style="vertical-align:middle;text-align:center">
    </a>
    <i class="line"></i>
    <h3 class="fs36">老师-注册</h3>
</header>

<form id="registerForm" action="/registerSir" method="post">
    <div class="content slideIn">
        <div class="weui_cells weui_cells_form kform withcancelform registerform" style="margin-bottom:5%;">
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">账号</label></div>
                <div class="weui_cell_bd weui_cell_primary emailphone input-div">
                    <input id="email" class="weui_input fs32" type="text" name="email" placeholder="个人邮箱帐号">
                    <i class="cancel iconfont" style="display: none;"></i>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">密码</label></div>
                <div class="weui_cell_bd weui_cell_primary input-div">
                    <input id="password" class="weui_input fs32" type="password" name="password" placeholder="请输入8-12位密码">
                    <i class="cancel iconfont" style="display: none;"></i>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">姓名</label></div>
                <div class="weui_cell_bd weui_cell_primary input-div">
                    <input id="name" class="weui_input fs32" type="text" name="name" placeholder="真实中文姓名">
                    <i class="cancel iconfont" style="display: none;"></i>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">教师号</label></div>
                <div class="weui_cell_bd weui_cell_primary input-div">
                    <input id="userID" class="weui_input fs32" type="text" name="userID" placeholder="请输入9位数字教师号">
                    <i class="cancel iconfont" style="display: none;"></i>
                </div>
            </div>

            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">学校</label></div>
                <div class="weui_cell_bd weui_cell_primary input-div">
                    <input id="school" class="weui_input fs32" type="text" name="school" placeholder="学校"
                           value="广东金融学院">
                    <i class="cancel iconfont" style="display: none;"></i>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label fs32">验证码</label></div>
                <div class="weui_cell_bd weui_cell_primary input-div">
                    <input id="verifyCode" class="weui_input fs32" type="text" name="verifyCode" style="width: 35%;"
                           placeholder="验证码">
                    <i class="cancel iconfont" style="display: none;"></i>
                    <%--验证码--%>
                    <img class="verifyimg reloadverify" style="width:50%;margin-left:40px;" alt="点击切换"
                         onclick="this.src='/defaultKaptcha?d='+new Date()*1" src="/defaultKaptcha">
                </div>
            </div>
        </div>
        <div class="login-btn">
            <a href="javascript:;" class="log-btn fs32" id="registerClick">注册并绑定</a>
        </div>
    </div>

    <!-- 提示框 -->
    <div  id="tipWindow">
        <div class="gTips" ><span style="background-color: #EA3640">${tipInfo}</span></div>
    </div>

</form>
<script>
    $("#email").blur(checkEmail);
    $("#password").blur(checkPassword);
    $("#name").blur(checkName);
    $("#userID").blur(checkUserID);
    $("#school").blur(judge);
    $("#verifyCode").blur(judge);

    setTimeout('$("#tipWindow").addClass("hidden")',3000);
</script>




</body>
</html>
