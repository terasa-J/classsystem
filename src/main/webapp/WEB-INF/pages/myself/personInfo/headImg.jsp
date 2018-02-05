<%--
  User: Jiang Jiahong
  Date: 2018/1/4
  Time: 17:25
  Description:"我"板块 —— “个人资料” 板块 —— 设置头像
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
    <link type="text/css" href="../css/myself/setting-1ab028fe81.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/myself/cropper.min.css">
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/dist/lrz.all.bundle.js"></script>
    <!-- mobileBUGFix.js 兼容修复移动设备 -->
    <script src="../js/dist/mobileFix.mini.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }

    .file {
        position: relative;
        display: inline-block;
        border: 1px solid #333;
        padding: 4px 20px;
        overflow: hidden;
        text-decoration: none;
        text-indent: 0;
        line-height: 20px;
        border-radius: 20px;
        color: #333;
        font-size: 15px;

    }

    .file input {
        position: absolute;
        font-size: 100px;
        left: 0;
        top: 0;
        opacity: 0;
    }
    </style>
</head>
<body style="background: rgb(236, 236, 236);">

<div class="page-inner page-fixed" id="page-1511690716179" style="background-color:#ececec">
    <form class="avatar-form" id="uploadForm" action="setHeadImg" enctype="multipart/form-data" method="post">
        <header class="header-item" style="background-color:#464646">
            <a href="javascript:history.back(-1);" class="icon-back">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow">设置头像</h3>

            <a href="javascript:;" class="file  button fs30">&nbsp;&nbsp;&nbsp;选择图片
                　<input type="file" accept="image/*" name="file">
            </a>
        </header>

        <div class="page-auto absolute">
            <div id="photoClip">
                <div class="container" id="crop-avatar">
                    <div id="avatar-modal">
                        <span class="uploadoccupy">请点击选择图片</span>
                        <div class="modal-body">
                            <div class="avatar-body">
                                <div class="avatar-wrapper" id="avatar-wrapper"  style="padding-top:10px;text-align: center;vertical-align: middle"></div>

                            <!-- 去掉 disabled 就可以点击 -->
                                <a href="javascript:;" id="upload" class="avatar-save uploadImg disabled" >上传图片</a>
                                <%--保存图片的URL 传递给服务器--%>
                                <input type="hidden" id="imgUrl" name="imgUrl" value="">
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </div>
    </form>



</div>
</div>

</body>
<script type="text/javascript">
    document.querySelector("input").addEventListener('change', function () {
        //先判断是否为图片格式
        var that = this;
        var filepath = $(that).val();
        if (filepath == "") {
            return;
        }
        var extStart = filepath.lastIndexOf(".");
        var ext = filepath.substring(extStart, filepath.length).toUpperCase();
        if (".jpg|.png|.bmp|.jpeg".toUpperCase().indexOf(ext.toUpperCase()) == -1) {
            alert("只允许上传jpg、png、bmp、jpeg格式的图片");
            return false;
        }

        //在界面上显示图片
        lrz(that.files[0], {
            width: 800
        }).then(function (rst) {
            var img = new Image();

            var div = document.getElementById("avatar-wrapper");
           div.style.width = "520px";
            div.style.height = "200px";
            div.style.display = "block";
            //展示图片
            div.appendChild(img);
            //上传图片按钮可用
            $("#upload").removeClass("disabled")
            $("#upload").attr("href", "javascript:document:uploadForm.submit();");
            //保存图片地址
            img.src = rst.base64;
            $("#imgUrl").val(img.src);

            return rst;
        }).catch(function (err) {
            // 处理失败会执行
            console.log(err);
           // alert(err);
        }).always(function () {
            // 不管是成功失败，都会执行
            console.log(err);
           // alert("always");
        });
    });

  </script>

</html>