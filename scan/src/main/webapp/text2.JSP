<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%!
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://120.77.222.221:3306/shop?characterEncoding=UTF-8";
    public static final String DBUSER = "root";
    public static final String PASSWORD = "yinghan9.12.25";
%>
<%
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT gid,title,pubdate,price,amount,lid,aid FROM goods";
%>
<%
    Class.forName(DBDRIVER);
    conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
    pstmt = conn.prepareStatement(sql);
    rs = pstmt.executeQuery();
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>分页处理</title>
</head>

<body>
<table border="1" width="100%" bgcolor="#f2f2f2">
    <tr>
        <tb>商品编号</tb>
        <tb>标题</tb>
        <tb>价格</tb>
        <tb>库存</tb>
        <tb>商品类型</tb>
        <tb>管理员</tb>
        <tb>更新时间</tb>
    </tr>
    <%
        while(rs.next()){
            int gid = rs.getInt(1);
            String title = rs.getString(2);
            Date pubdate = rs.getDate(3);
            float price = rs.getFloat(4);
            int amount = rs.getInt(5);
            int lid = rs.getInt(6);
            String aid = rs.getString(7);
    %>
    <tr>
        <tb><%=gid%></tb>
        <tb><%=title%></tb>
        <tb><%=price%></tb>
        <tb><%=amount%></tb>
        <tb><%=lid%></tb>
        <tb><%=aid%></tb>
        <tb><%=pubdate%></tb>
    </tr>
    <%
        }
        conn.close();
    %>
</table>
</body>
</html>