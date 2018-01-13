<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <mata charset="utf-8"/>
    <title></title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<iframe stc="http://120.77.222.221/jd/index.html" style="width: 100%;height: 800px;" frameborder="0"/>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    //获取用户信息
    var lon;    //定义经度
    var lat;    //定义纬度
    //实时获取用户经纬度
    navigator.geolocation.watchPosition(onSuccess,onError,options);
    function onSuccess(){   //调用成功所执行方法
        lon = position.coords.longitude ;
        lat = position.coords.latitude;
        //上传到服务器
        $.ajax({
            url:'postion',      //上传的地址
            type:'post',        //上传的方式
            data:{"lon":lon,"lat":lat}    //上传的参数
            //防护的结果
        });
    }
    function onError(){     //调用失败所执行方法
        $.ajax({
            url:'postion',      //上传的地址
            type:'post',        //上传的方式
            data:{"err":err}    //上传的参数
            //防护的结果
        });
    }
    //约束信息
    var options = {};

    //发送到服务器
</script>
</body>
</html>
