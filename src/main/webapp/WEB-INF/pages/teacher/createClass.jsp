<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 15:57
  Description:创建班级
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
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>
<body>


<div class="page-inner page-fixed" id="page-1511669891869" style="background-color:#ececec">
    <form id="confrimCreateClassForm" action="confirmCreateClass" method="post">
        <header class="header-item" style="background-color:#464646">
            <a href="javascript:history.back(-1)" class="icon-back">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">新建班级</h3>
            <input type="submit" class="button fs28" value="保存">
        </header>
        <div class="page-auto absolute">
            <div class="weui_cells weui_cells_form">
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs32">班级名称</label></div>
                    <div class="weui_cell_bd weui_cell_primary input-div">
                        <input class="weui_input fs32" type="text" name="className" placeholder="输入班级名称" value=""
                               autofocus="autofocus">
                    </div>
                </div>
            </div>
            <div class="weui_cells weui_cells_form">
                <div class="weui_cell">
                    <div class="weui_cell_hd"><label class="weui_label fs32">班级编号</label></div>
                    <div class="weui_cell_bd weui_cell_primary input-div">
                        <input class="weui_input fs32" type="text" name="courseID" placeholder="输入班级编号（不可重复）" value=""
                               autofocus="autofocus">
                    </div>
                </div>
            </div>
        </div>

            <div class="weui_cells_title fs28 gray170">创建完成后，学生可通过6位邀请码加入班级</div>

    </form>
</div>

</body>
</html>
