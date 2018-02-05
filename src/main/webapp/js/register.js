/*老师 学生 注册页面*/

//验证邮箱
function checkEmail() {
    var email = $("#email").val();
    var regEmail = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var isEmail = regEmail.test(email);
    if (isEmail == false) {
        $("#tipWindow").removeClass("hidden");
        $(".gTips span").text("邮箱输入格式错误");
        setTimeout('$("#tipWindow").addClass("hidden")', 3000);
    }
}

//验证密码   8-12位字符
function checkPassword() {
    var password = $("#password").val();
    var regPassword = /^.{8,12}$/;
    var isPassword = regPassword.test(password);
    if (isPassword == false) {
        $("#tipWindow").removeClass("hidden");
        $(".gTips span").text("请设置8-12位密码");
        setTimeout('$("#tipWindow").addClass("hidden")', 3000);
    }
}

//姓名  中文
function checkName() {
    var name = $("#name").val();
    var reName = /^[\u4e00-\u9fa5]{0,}$/;
    var isName = reName.test(name);
    if (isName == false) {
        $("#tipWindow").removeClass("hidden");
        $(".gTips span").text("请输入中文姓名");
        setTimeout('$("#tipWindow").addClass("hidden")', 3000);
    }
}

//个人ID 学号 教师号 9位数字
function checkUserID() {
    var userID = $("#userID").val();
    var reUserID = /^\d{9}$/;
    var isUserID = reUserID.test(userID);
    if (isUserID == false) {
        $("#tipWindow").removeClass("hidden");
        $(".gTips span").text("学号/教师号 输入有误");
        setTimeout('$("#tipWindow").addClass("hidden")', 3000);
    }
}

//全部验证
function judge() {
    var email = $("#email").val();
    var password = $("#password").val();
    var name = $("#name").val();
    var userID = $("#userID").val();
    var school = $("#school").val();
    var verifyCode = $("#verifyCode").val();
    if (email && password && name && userID && school && verifyCode) {
        $(".log-btn").addClass("active");
        $("#registerClick").attr("href", "javascript:document:registerForm.submit();");
    } else {
        $(".log-btn").removeClass("active");
        $("#registerClick").attr("href", "javascript:;");
    }
}