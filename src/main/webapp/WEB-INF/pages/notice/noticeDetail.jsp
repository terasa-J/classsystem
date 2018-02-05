<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 15:30
  Description: 公告详情
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
    <link href="../css/common/layer.css" rel="stylesheet" type="text/css">
    <link type="text/css" href="../css/topic/homework-1d298e9945.css" rel="stylesheet">
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body style="background: rgb(233, 241, 243);">
<div class="page-inner" id="page-notice-detail">

    <header class="header-item" style="background-color: rgb(0, 117, 142);">
        <a href="javascript:history.back(-1);" class="icon-back">
            <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
        </a>
        <i class="line"></i>
        <h3 class="fs36 text-overflow">公告详情</h3>
    </header>
    <div class="hdetail workspace">
        <div class="detail-page">
            <div class="homework-list border-1px" >
                <div class="notice-contentxt" style="padding:0 5px 10px;">

                        <h3 class="notice-name fs36"
                            style="word-wrap: break-word;margin-top: 10px">${notice.title}</h3>

                        <div class="notice-stat-block">
                            <time class="fs24" style="display:inherit;">发布人：${teacher.name}</time>
                        <time class="fs24" style="display:inherit;">发布时间：${notice.createtime}</time>
                    </div>
                        <br>
                        <h3 class="notice-name fs30" style="wword-wrap: break-word;">公告正文</h3>
                        <div class="fs28 detailContent">${notice.content}</div>
                    </div>
                </div>
            </div>

        </div>


    </div>

</body>
</html>
