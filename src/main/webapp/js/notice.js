<!-- 确认 发布公告 以及 确认 更新公告-->
function judge() {
    var title = $("#title").val();
    var content = $("#content").val();
    if (title && content) {
        $("#confirm").addClass("active");
        $("#confirm").attr("href", "javascript:document:confirmDoNoticeForm.submit();");
    } else {
        $("#update").removeClass("active");
        $("#update").attr("href", "javascript:;");
        $(".gTips span").text("标题与内容均不能为空");
    }
}

