<!-- 确认 发布公告 以及 确认 更新公告-->
function judge() {
    var title = $("#title").val();
    var content = $("#content").val();
    if (title && content) {
        $("#confirm").addClass("active");
        $("#confirm").attr("href", "javascript:document:confirmDoNoticeForm.submit();");
    } else {
        $("#confirm").removeClass("active");
        $("#confirm").attr("href", "javascript:;");
        $("#tipWindow").removeClass("hidden");
        $(".gTips span").text("标题与内容均不能为空");
        setTimeout('$("#tipWindow").addClass("hidden")', 2000);
    }
}

