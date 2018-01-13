<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.sql.Date" %>
<%@ page import="javassist.compiler.ast.Keyword" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%
    int allRecorders = 0;   //保存总记录数
    String columnData = null;
    String keyWord = "";    //默认查询关键字
    String column = null;    //默认查询列
%>
<%
    try {
        allRecorders = Integer.parseInt(request.getParameter("allRecorders"));
    }catch (Exception e){}
    keyWord = request.getParameter("keyWord");
    column = request.getParameter("column");
    columnData = request.getParameter("columnData");
%>
<div>
    <%
        if (columnData != null){
    %>
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
    <%
        }
    %>
    <input type="text" name="kw" id="kw" value="<%=keyWord%>">
    <button onclick="goSplit(1)">检索</button>&nbsp共有<%=allRecorders%>条记录
</div>