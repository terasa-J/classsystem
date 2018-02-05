<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 15:29
  Description: 教师公告 板块
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="../css/common/layer.css" rel="stylesheet" type="text/css">
    <script src="../js/jquery-3.2.1.min.js"></script>

    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }

    .cs-pop, .pop-bg, .weui_mask_transition, .weui_actionsheet {
        position: absolute !important;
    }</style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner" id="page-course">
    <header class="header-item" style="background-color: rgb(0,117,142);">
        <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow" id="coursename">${course.cname}</h3>

    </header>

    <nav class="coursenav fs30" style="background-color: rgb(0,117,142);">
        <a href="sirAttend?index=${index}" class="">课堂考勤</a>
        <a href="javascript:;" class="active">教师公告</a>
    </nav>

    <!-- 公告列表 -->


    <div class="mainView workspace">
        <div class="notice-list-container">
            <div class="content">
                <div class="send-an">
                    <a href="createNoticePage?courseId=${courseId}&sirId=${sirId}" id="publish-topic">
                        <i class="iconfont fs28">
                            <img src="../img/topic/newTopic.png"
                                 style="vertical-align: middle;text-align: center;">
                        </i>
                        <span class="fs26">发布新通知（教师）</span>
                    </a>
                </div>

                <ul id="notice-lists" class="notice-lists announce-notify-lists">
                    <c:forEach items="${noticeList}" var="noticeList" varStatus="status">
                        <li class="href" data-sort="0">
                                <%--点击每一个详情--%>

                            <div class="notice-title">
                                <h3 class="notice-name fs36" style="word-wrap: break-word;"> <%--为了让3颗按钮靠右--%>
                                    <a href="noticeDetail?noticeId=${noticeList.noticeid}">
                                        <h3 class="notice-name fs36" style="word-wrap: break-word;">
                                                ${noticeList.title}
                                        </h3>
                                    </a>
                                </h3>
                                <div class="opt-btn">
                                  <span class="iconfont fs36">
                                     <img id="${noticeList.noticeid}" name="${courseId}" onclick="showClassDialog(this)"
                                          src="../img/topic/updateTopic.png">
                                </span>
                                </div>
                            </div>

                            <div class="notice-content">
                                <div class="fs28 limit">
                                        ${noticeList.content}
                                </div>
                            </div>
                            <div class="notify-annex-talk">
                                <time class="notice-timer fs24">发布时间：${noticeList.createtime}</time>
                            </div>

                        </li>
                    </c:forEach>
                </ul>


            </div>
        </div>

    </div>


</div>

<!-- 点击班级上的更多按钮  3个点-->
<div class="actionSheetWrapArea hidden" id="actionSheet">
    <div class="weui_mask_transition weui_fade_toggle" id="mask" style="display: block;"></div>
    <div class="weui_actionsheet fs30 weui_actionsheet_toggle" id="weui_actionsheet">
        <div class="weui_actionsheet_menu">
            <a href="javascript:;" id="clickUpdateNotice">
                <div class="weui_actionsheet_cell">编辑公告</div>
            </a>
            <div class="weui_actionsheet_cell" id="topicDel" onclick="deleteTopic()">删除公告</div>
        </div>
        <div class="weui_actionsheet_action">
            <div class="weui_actionsheet_cell" id="actionsheet_cancel" onclick="cancelClassDialog()">取消</div>
        </div>
    </div>
</div>
</div>


<!-- 删除话题 -->
<div class="hidden" id="deleteTopicDialog">
    <div class="cs-pop popDialogArea " style="display:block">
        <h3 class="title fs30 border-1px">确认删除此公告？</h3>
        <div class="opt"><a href="javascript:;" class="cancel fs30 " onclick="cancelDeleteTopic()">取消</a>
            <a href="javascript:;" class="sure fs30 border-1px-left " id="confirmDeleteNotice">确定</a>
        </div>
    </div>
    <div class="pop-bg isDel" style="display:block"></div>
</div>


<!-- 确定删除 信息框 -->
<div class="gTips hidden" id="show-tip"><span>删除成功</span></div>

<%--提示框--%>
<div class="" id="tipWindow">
    <div class="gTips"><span style="background-color: #EA3640">${tipInfo}</span></div>
</div>

</body>
</html>

<script>
    setTimeout('$("#tipWindow").addClass("hidden")', 2000);

    /*点击班级的  3个点*/
    function showClassDialog(e) {
        $("#actionSheet").removeClass("hidden");
        var noticeid = $(e).attr("id");
        var courseid = $(e).attr("name");
        //修改编辑班级的URl
        $("#clickUpdateNotice").attr("href", "updateNotice?noticeid=" + noticeid + "&courseid=" + courseid);

        //修改确定删除中的URL
        $("#confirmDeleteNotice").attr("href", "confirmDeleteNotice?noticeid=" + noticeid + "&courseid=" + courseid);
    }

    /*点击班级的  3个点   ——> 取消 */
    function cancelClassDialog() {
        $("#actionSheet").addClass("hidden");
    }

    /*点击班级的  3个点   ——> 删除话题 */
    function deleteTopic() {
        $("#deleteTopicDialog").removeClass("hidden");
        cancelClassDiaolog();
    }

    /*点击删除话题 ——> 取消 */
    function cancelDeleteTopic() {
        $("#deleteTopicDialog").addClass("hidden");
    }


</script>