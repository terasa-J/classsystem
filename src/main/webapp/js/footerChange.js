<!-- 底部信息脚本 -->
/*点击“课堂”，颜色以及图片切换*/
function clickClass() {
    $("#classA").addClass("active").siblings().removeClass();
    $("#imgClass").attr("src", "../img/common/myClass2.png");
    unClickMyself();
}

/*“课堂”按钮失效，图片还原*/
function unClickClass() {
    $("#imgClass").attr("src", "../img/common/myClass1.png");

}

/*点击“我”，颜色以及图片切换*/
function clickmyself() {
    $("#myselfA").addClass("active").siblings().removeClass();
    $("#imgMyself").attr("src", "../img/common/myself2.png");
}

/*“我”按钮失效，图片还原*/
function unClickMyself() {
    $("#imgMyself").attr("src", "../img/common/myself1.png");

}
