<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/16/016
  Time: 9:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page import="com.home.factory.ServiceFactory" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--ie使用edge渲染模式-->
    <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport"
          name="viewport">
    <meta name="renderer" content="webkit">
    <!--360渲染模式-->
    <meta name="format-detection" content="telephone=notelphone=no, email=no"/>
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    <link rel="shortcut icon" href="home/favicon.ico" type="image/x-icon"/>
    <!-- 是否启用 WebApp 全屏模式，删除苹果默认的工具栏和菜单栏 -->
    <meta name="apple-touch-fullscreen" content="yes">
    <!-- 设置苹果工具栏颜色:默认值为 default，可以定为 black和 black-translucent-->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <!-- 不让百度转码 -->
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!-- 针对手持设备优化，主要是针对一些老的不识别viewport的浏览器，比如黑莓 -->
    <meta name="HandheldFriendly" content="true">
    <!-- 微软的老式浏览器 -->
    <meta name="MobileOptimized" content="320">
    <!-- uc强制竖屏 -->
    <meta name="screen-orientation" content="portrait">
    <!-- QQ强制竖屏 -->
    <meta name="x5-orientation" content="portrait">
    <!-- UC应用模式 -->
    <meta name="browsermode" content="application">
    <!-- QQ应用模式 -->
    <meta name="x5-page-mode" content="app">
    <!-- windows phone 点击无高光 -->
    <meta name="msapplication-tap-highlight" content="no">
    <title>智能家居</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <style>
        .transparent {
            background-color: #5E5E5E;
            z-index: 100; /*至于顶层*/
            position: inherit; /*从父元素继承 position 属性的值*/
            filter: alpha(opacity=50);
            -moz-opacity: 0.5; /*对mozilla firefox火狐浏览器实现半透明，win IE不认此属性，-moz-opacity:0.5相当于设置半透明为50%*/
            -khtml-opacity: 0.5; /*对win IE设置半透明滤镜效果，filter:alpha(Opacity=80)代表该对象80%半透明，火狐浏览器不认*/
            opacity: 0.5; /*对除IE外所有浏览器支持包括谷歌，放最后主要针对谷歌浏览器，opacity: 0.5;表示设置50%半透明*/
            text-align: center;
            width: 325px;
            height: 500px;
            right: 15%; /*基于父标签相对定位*/
            top: 12%;
        }
        .silder-main-1 {
            position: inherit;
            top: 60%;
            left: 35%;
        }
        #deng {
            width: 100px;
            height: 100px;
            border-radius: 100px;
            font-size: 18px;
        }
        .silder-main-2 {
        }
        .silder-main-3 {
        }
        .silder-main-4 {
        }
        .silder-top {
            z-index: 200;
            margin-top: 0px;
            width: 100%;
            height: 28px;
            filter: alpha(opacity=50);
            -moz-opacity: 0.5;
            -khtml-opacity: 0.5;
            opacity: 0.5;
        }
    </style>
</head>

<body>
<from>
    <div class="silder-top">欢迎您，${sessionScope.username}</div>
    <div class="js-silder">
        <div class="silder-scroll">
            <div class="silder-main">
                <div class="silder-main-img">
                    <img src="images/1.jpg" alt="">
                    <div class="transparent">
                        <div class="silder-main-1">
                            <button name="dengkg" id="deng">${kaiguang.deng}</button>
                        </div>
                    </div>
                </div>
                <div class="silder-main-img">
                    <img src="images/2.jpg" alt="">
                    <div class="transparent">
                        <div class="silder-main-2">

                        </div>
                        <div>
                            <button name="ktkg" class="kt-long" id="ktkg">开</button>
                            <button name="moshi" class="kt-long" id="moshi">模式</button>
                        </div>
                        <div>
                            <button name="fengsu" class="kt-short" id="fengsu">风速</button>
                            <button name="fengxiang" class="kt-short" id="fengxiang">风向</button>
                            <button name="saofeng" class="kt-short" id="saofeng">扫风</button>
                        </div>
                        <div>
                            <button name="jian" class="kt-short" id="jian">－</button>
                            <button name="wendu" class="kt-short" id="wendu">温度</button>
                            <button name="jia" class="kt-short" id="jia">＋</button>
                        </div>
                        <div>
                            <button name="dingshi" class="kt-short" id="dingshi">定时</button>
                            <button name="shuimian" class="kt-short" id="shuimian">睡眠</button>
                            <button name="shuxian" class="kt-short" id="shuxian">数显</button>
                        </div>
                    </div>
                </div>
                <div class="silder-main-img">
                    <img src="images/3.jpg" alt="">
                    <div class="transparent">
                        <div class="silder-main-3">
                            <label>角度</label><input type="text" name="jiaodu" value="${kaiguang.jiaodu}"/>
                        </div>
                        <div>
                            <button>开</button>
                            <button>关</button>
                        </div>
                    </div>
                </div>
                <div class="silder-main-img">
                    <img src="images/4.jpg" alt="">
                    <div class="transparent">
                        <h2>室内环境监控</h2>
                        <div class="silder-main-4">

                        </div>
                        <h3>
                            <label>温&nbsp;&nbsp;度：</label><input type="text" name="wendu" value="${kaiguang.wendu}"/><br/>
                            <label>湿&nbsp;&nbsp;度：</label><input type="text" name="shidu" value="${kaiguang.shidu}"/><br/>
                            <label>烟雾浓度：</label><input type="text" name="nongdu" value="${kaiguang.nongdu}"/><br/>
                            <label>光照强度：</label><input type="text" name="qiangdu" value="${kaiguang.qiangdu}"/><br/>
                        </h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</from>
<script src="js/jquery-3.1.1.js" type="text/javascript"></script>
<script src="js/wySilder.min.js" type="text/javascript"></script>
<script>
    $(function () {
        $(".js-silder").silder({
            auto: true,//自动播放,传入任何可以转化为true的值都会自动轮播
            speed: 20,//轮播图运动速度
            sideCtrl: true,//是否需要侧边控制按钮
            bottomCtrl: true,//是否需要底部控制按钮
            defaultView: 0,//默认显示的索引
            interval: 3000,//自动轮播的时间,以毫秒为单位,默认3000毫秒
            activeClass: "active",//小的控制按钮激活的样式,不包括作用两边,默认active
        });
    });
</script>
</body>
</html>