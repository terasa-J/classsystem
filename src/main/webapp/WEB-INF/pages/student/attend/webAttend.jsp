<%--
  User: Jiang Jiahong
  Date: 2018/1/5
  Time: 14:41
  Description:“学生”板块 —— 点击“课堂”—— 课堂签到 板块 —— 现在去签到
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
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
    <link type="text/css" href="../css/student/stuCourse-06127df797.css" rel="stylesheet">
    <%--加载高德地图--%>
    <script type="text/javascript"
            src="http://webapi.amap.com/maps?v=1.4.3&key=ec3226d69643a423012abef447eb8db1"></script>
    <!-- UI组件库 1.0 -->
    <script src="//webapi.amap.com/ui/1.0/main.js?v=1.0.11"></script>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <style type="text/css">body {
        position: relative;
        max-width: 520px;
        margin: 0 auto;
        overflow: hidden;
    }
    </style>
</head>

<body onload="javascript:toolBar.doLocation()">
<div class="page-inner" id="page-getlocation-confirm">
    <form action="confirmAttend" method="post" id="confirmAttendForm">
        <header class="header-item" style="background-color: rgb(0, 117, 142);">
            <a href="javascript:history.back(-1)" class="icon-back" data-pjax="">
                <img src="../img/common/backWhite.png" style="vertical-align: middle;text-align: center;">
            </a>
            <i class="line"></i>
            <h3 class="fs36 text-overflow" id="attencename">确认签到位置</h3>

        </header>

        <div id="wrapper-getLocation">
            <div class="location-map-checkin" style="height:80px;">
                <a href="javascript:document:confirmAttendForm.submit();" class="gotocheckin">
                    <span class="top">定位准确</span>
                    <span class="bottom">点击签到</span>
                </a>
                <a href="javascript:void(0)" onclick="location.reload()" class="reloadcation" id="start">
                    <span class="top">定位有误</span>
                    <span class="bottom">重新定位</span>
                </a>
            </div>
            <%--显示位置--%>
            <div style="padding-bottom: 10px">
                <input type="text" id="location" name="location" class="fs30" style="width: 100%;font-size: 15px">

                <input type="hidden" name="attendanceId" value="${attendanceId}">
                <input type="hidden" name="attendanceCode" value="${attendanceCode}">
                <input type="hidden" name="index" value="${index}">
            </div>

        </div>

            <%--显示地图--%>
            <div id="container"
                 style="height:560px;overflow: hidden; position: relative;  background-color: rgb(243, 241, 236); color: rgb(0, 0, 0); text-align: left;">
            </div>



    </form>
</div>


</body>
<%--提示框--%>
<div class="" id="tipWindow">
    <div class="gTips"><span style="background-color: #EA3640" id="tip">${tipInfo}</span></div>
</div>
</html>

<script>
    setTimeout('$("#tipWindow").addClass("hidden")', 3000);
    /**/
    //自定义定位标记
    var toolBar;

    var customMarker = new AMap.Marker({
        offset: new AMap.Pixel(-14, -34),//相对于基点的位置
        icon: new AMap.Icon({  //复杂图标
            size: new AMap.Size(27, 36),//图标大小
            image: "http://webapi.amap.com/images/custom_a_j.png", //大图地址
            imageOffset: new AMap.Pixel(-28, 0)//相对于大图的取图位置
        })
    });

    //初始化地图对象，加载地图
    var map = new AMap.Map('container', {
        resizeEnable: true
    });

    //地图中添加地图操作ToolBar插件
    map.plugin(["AMap.ToolBar"], function () {
        toolBar = new AMap.ToolBar({locationMarker: customMarker}); //设置地位标记为自定义标记
        map.addControl(toolBar);
    });


    var geolocation;
    map.plugin('AMap.Geolocation', function () {
        geolocation = new AMap.Geolocation({
            enableHighAccuracy: true,//是否使用高精度定位，默认:true
            timeout: 10000,          //超过10秒后停止定位，默认：无穷大
            buttonOffset: new AMap.Pixel(10, 20),//定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)
            zoomToAccuracy: true,      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false
            buttonPosition: 'RB',
            maximumAge: 0,           //定位结果缓存0毫秒，默认：0
            convert: true,           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
            showButton: true,        //显示定位按钮，默认：true
            showMarker: true,        //定位成功后在定位到的位置显示点标记，默认：true
            showCircle: true,        //定位成功后用圆圈表示定位精度范围，默认：true
            panToLocation: true,     //定位成功后将定位到的位置作为地图中心点，默认：true
            zoomToAccuracy: true      //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false

        });
        map.addControl(geolocation);
        geolocation.getCurrentPosition();
        AMap.event.addListener(geolocation, 'complete', onComplete);//返回定位信息
        AMap.event.addListener(geolocation, 'error', onError);      //返回定位出错信息
    });

    //解析定位结果
    function onComplete(data) {
        var str = ["定位成功"];
        var location = data.formattedAddress;
        document.getElementById('tip').innerHTML = str;
        document.getElementById('location').value = "地址：" + location;

    }

    //解析定位错误信息
    function onError(data) {
        var error = ['定位失败'];
        document.getElementById('tip').innerHTML = error;
        document.getElementById('location').value = "错误提示：" + data.info + '--' + data.message;
    }


</script>


</script>