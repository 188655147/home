<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="com.wilya.dbc.DatabaseConnection"%>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
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
    <title>分页处理</title>
</head>

<body>
<%
    DatabaseConnection dbc = new DatabaseConnection();
    dbc.getConnection();
%>
</body>
</html>