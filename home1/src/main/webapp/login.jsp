<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <style type="text/css">
        body {
            background-color: gray;
            text-align:center;
            margin:0 auto;
        }

        #container{
        }
        #bd{
            position: absolute;
            top:30%;
            left:43%;
            margin-left:-50px;
            margin-top:-25px;
            text-align: center;
            width: 300px;
            height: 200px;
            border-color: #003366;
            background-color: white;
            filter:alpha(Opacity=70); /*不透明度*/
            -moz-opacity:0.7;
            opacity: 0.7;
        }
        .ue-clear{
            text-align: right;
            margin-right: 40px;
        }
    </style>
</head>
<script type="text/javascript">
    function confirmlogin() {
        var userno = document.getElementById("userno");
        var password = document.getElementById("password");
        if (userno.value == "" || password.value == "") {
            window.alert("登录ID、登录密码不能为空！");
            return false;
        } else{
            return document.from1.submit();
        }
    }
</script>
<body>
<form name="from1" action="login" method="post">
    <div id="container">
        <div id="bd">
            <div class="login">
                <div class="login-top">
                    <h1>用户登录</h1>
                </div>
                <div class="login-input">
                    <p class="user ue-clear">
                        <label>用户名</label>
                        <input type="text" id="userno" name="user.userno"/>
                    </p>
                    <p class="password ue-clear">
                        <lable>密&nbsp;码</lable>
                        <input type="password" id="password" name="user.password"/>
                    </p>
                </div>
                <div class="login-below">
                    <button id="submit" name="submit" onclick="confirmlogin()">登录</button>
                    <button id="reset" name="reset">重置</button>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
