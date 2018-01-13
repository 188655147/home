<%--
  Created by IntelliJ IDEA.
  User: xuyinghan
  Date: 2017/12/13
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>刷脸登陆</title>
    <style type="text/css">
        {
            margin: 0;
            padding: 0;
        }
        #btn{
            width: 200px;
            height: 40px;
            background: red;
            text-align:center;
            line-height:40px;
            border-radius:12px;
        }
    </style>
</head>
<body>
    <%--显示摄像头--%>
    <%--在页面上如何调用摄像头
        1.在页面调用摄像头
        2.获取到摄像头捕获的用户面部信息
        3.从数据库取出本地的面部信息
        4.将摄像头捕获的面部信息和本地面部信息进行比对
        5.对比为ture则跳转到主页，否则提示失败
    --%>
    <video src="" id="video" autoplay width="540" height="400"></video>
    <canvas id="canvas"></canvas>
    <div id="btn">截取</div>
    <script type="text/javascript">
        var getUserMedia = (navigator.getUserMedia || navigator.ms);
        getUserMedia.call(navigator, {video: true}, onsuccess, onerror);

        function onsuccess(localMediaStream) {
            var OVideo = document.getElementsById('video');
            OVideo.src = URL.createObjectURL(localMediaStream);
        }

        function onerror(e) {
            console.log(e);
        }

        var OBtn = document.getElementsById('btn');
        OBtn.onclick = function () {
            //获取面部信息
            var context = canvas.getContext("2d");
            var canvas = document.getElementById('canvas');
            context.drawImage(video,0,0,534,400);
            var imgSrc = canvas.toDataURL('image/png');
            var face = imgSrc.split(",")[1];
        }
    </script>
</body>
</html>
