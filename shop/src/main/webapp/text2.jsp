<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Date" %>
<%@ page import="javassist.compiler.ast.Keyword" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%!
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://120.77.222.221:3306/shop?characterEncoding=UTF-8";
    public static final String DBUSER = "root";
    public static final String PASSWORD = "yinghan9.12.25";
%>
<%
    String url = "text2.jsp";
    int currentPage = 1;
    int lineSize = 3;
    int allRecorders = 0;   //保存总记录数
    String column = "title";    //默认查询列
    String columnData = "商品名称:title|商品编号:gid|商品价格:price";    //查询类型
    String keyWord = "";    //默认查询关键字
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
%>
<%
    try {
        currentPage = Integer.parseInt(request.getParameter("cp"));
    }catch (Exception e){}
    try {
        lineSize = Integer.parseInt(request.getParameter("ls"));
    }catch (Exception e){}
    if (request.getParameter("kw") != null){
        keyWord = request.getParameter("kw");
    }
    if (request.getParameter("col") != null){
        column = request.getParameter("col");
    }
%>
<%
    String sql = "SELECT COUNT(gid) FROM goods WHERE " +column+ " LIKE ?";
    Class.forName(DBDRIVER);
    conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,"%"+keyWord+"%");
    rs = pstmt.executeQuery();
    if(rs.next()) {
        allRecorders = rs.getInt(1);
    }
%>
<%
    sql = "SELECT gid,title,pubdate,price,amount,lid,aid FROM goods WHERE " +column+ " LIKE ? LIMIT ?,?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,"%"+keyWord+"%");
    pstmt.setInt(2,currentPage < 1 ? 0 : (currentPage - 1) * lineSize);
    pstmt.setInt(3,lineSize < 1 ? 1 : lineSize);
    rs = pstmt.executeQuery();
%>
<html>
<head>

</head>
<body>
<div id="oDiv">
    <div id="splitSearchDiv">
        <jsp:include page="split_page_plugin_search.jsp">
            <jsp:param name="columnData" value="<%=columnData%>"/>
            <jsp:param name="column" value="<%=column%>"/>
            <jsp:param name="keyWord" value="<%=keyWord%>"/>
            <jsp:param name="allRecorders" value="<%=allRecorders%>"/>
        </jsp:include>
    </div>
    <div id="dataDiv">
        <table border="1" width="100%" bgcolor="#f2f2f2">
            <tr>
                <td width="10%">商品编号</td>
                <td width="40%">标题</td>
                <td width="10%">价格</td>
                <td width="10%">库存</td>
                <td width="10%">商品类型</td>
                <td width="10%">管理员</td>
                <td width="10%">更新时间</td>
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
                <td><%=gid%></td>
                <td><%=title%></td>
                <td><%=price%></td>
                <td><%=amount%></td>
                <td><%=lid%></td>
                <td><%=aid%></td>
                <td><%=pubdate%></td>
            </tr>
            <%
                }
                conn.close();
            %>
        </table>
    </div>
    <div id="splitBarDiv">
        <jsp:include page="split_page_plugin_bar.jsp">
            <jsp:param name="currentPage" value="<%=currentPage%>"/>
            <jsp:param name="lineSize" value="<%=lineSize%>"/>
            <jsp:param name="column" value="<%=column%>"/>
            <jsp:param name="keyWord" value="<%=keyWord%>"/>
            <jsp:param name="allRecorders" value="<%=allRecorders%>"/>
            <jsp:param name="url" value="<%=url%>"/>
        </jsp:include>
    </div>
</div>
</body>
</html>