<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Date" %>
<%@ page import="javassist.compiler.ast.Keyword" %>

<%!
    public static final String DBDRIVER = "com.mysql.jdbc.Driver";
    public static final String DBURL = "jdbc:mysql://120.77.222.221:3306/shop?characterEncoding=UTF-8";
    public static final String DBUSER = "root";
    public static final String PASSWORD = "yinghan9.12.25";
%>
<%
    String url = "split_page_plugin_search.jsp";
    int currentPage = 1;
    int lineSize = 3;
    int allRecorders = 0;   //保存总记录数
    int pageSize = 0;       //保存总页数
    int lsData [] = new int[] {1,3,5,10,15,20,30,50,100};
    String columnData = "商品名称:title|商品编号:gid|商品价格:price";    //查询类型
    String column = "title";    //默认查询列
    String KeyWord = "";    //默认查询关键字
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "SELECT COUNT(gid) FROM goods WHERE " +column+ " LIKE ?";
%>
<%
    try {
        currentPage = Integer.parseInt(request.getParameter("cp"));
    }catch (Exception e){}
    try {
        lineSize = Integer.parseInt(request.getParameter("ls"));
    }catch (Exception e){}
    if (request.getParameter("kw") != null){
        KeyWord = request.getParameter("kw");
    }
    if (request.getParameter("col") != null){
        column = request.getParameter("col");
    }
%>
<%
    Class.forName(DBDRIVER);
    conn = DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,"%"+KeyWord+"%");
    rs = pstmt.executeQuery();
    if(rs.next()) {
        allRecorders = rs.getInt(1);
    }
%>
<%
    if (allRecorders > 0){
        pageSize = (allRecorders + lineSize - 1)/ lineSize;
    }else{
        pageSize = 1;
    }
%>
<%
    sql = "SELECT gid,title,pubdate,price,amount,lid,aid FROM goods WHERE " +column+ " LIKE ? LIMIT ?,?";
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1,"%"+KeyWord+"%");
    pstmt.setInt(2,currentPage < 1 ? 0 : (currentPage - 1) * lineSize);
    pstmt.setInt(3,lineSize < 1 ? 1 : lineSize);
    rs = pstmt.executeQuery();
%>
<html>
<head>

</head>
<body>
<div>
    请输入查询关键字：
    <select id="colSel">
        <%
            String result [] = columnData.split("\\|");
            for (int x = 0; x < result.length; x++){
                String temp[] = result[x].split(":");
        %>
        <option value="<%=temp[1]%>" <%=column.equals(temp[1])?"selected":""%>><%=temp[0]%></option>
        <%
            }
        %>
    </select>
    <input type="text" name="kw" id="kw" value="<%=KeyWord%>">
    <button onclick="goSplit(1)">检索</button>&nbsp共有<%=allRecorders%>条记录&nbsp共<%=pageSize%>页
</div>
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
<div>
    <button onclick="goSplit(1)" <%= currentPage <= 1? "disabled" : ""%>>首页</button>
    <button onclick="goSplit(<%=currentPage - 1%>)" <%= currentPage <= 1? "disabled" : ""%>>上一页</button>
    <button onclick="goSplit(<%=currentPage + 1%>)" <%= currentPage >= pageSize ? "disabled" : ""%>>下一页</button>
    <button onclick="goSplit(<%=pageSize%>)" <%= currentPage >= pageSize ? "disabled" : ""%>>尾页</button>
    跳转到：<select id="cpSel" onchange="goSplit(this.value)">
    <%
        for (int x = 1; x <= pageSize; x++){
    %>
    <option value="<%=x%>" <%= currentPage == x ? "selected" : ""%>><%=x%></option>
    <%
        }
    %>
    </select>页&nbsp
    每页显示：<select id="lsSel" onchange="goSplit(1)">
    <%
        for (int x = 0; x < lsData.length; x++){
    %>
    <option value="<%=lsData[x]%>" <%= lineSize == lsData[x] ? "selected" : ""%>><%=lsData[x]%></option>
    <%
        }
    %>
</select>行记录
</div>
<h3>currentPage = <%=currentPage%></h3>
<h3>lineSize = <%=lineSize%></h3>
<h3>allRecorders = <%=allRecorders%></h3>
<h3>pageSize = <%=pageSize%></h3>
<h3>keyWord = <%=KeyWord%></h3>
<script type="text/javascript">
    function goSplit(vcp) { //vcp传递cp参数
        var eleLs = document.getElementById("lsSel").value;
        var eleKw = document.getElementById("kw").value;
        var eleCol = document.getElementById("colSel").value;
        window.location = "<%=url%>?cp=" + vcp + "&ls=" + eleLs + "&kw=" + eleKw + "&col=" + eleCol;
    }
</script>
</body>
</html>