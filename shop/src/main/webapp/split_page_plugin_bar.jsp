<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://www.mldn.cn/c" %>
<%--
<div id="barDiv">
    <jsp:include page="split_page_plugin_bar.jsp">
        <jsp:param name="currentPage" value="<%=currentPage%>"/>
        <jsp:param name="lineSize" value="<%=lineSize%>"/>
        <jsp:param name="column" value="<%=column%>"/>
        <jsp:param name="keyWord" value="<%=keyWord%>"/>
        <jsp:param name="allRecorders" value="<%=allRecorders%>"/>
        <jsp:param name="url" value="<%=url%>"/>
    </jsp:include>
</div>
--%>
<%
    request.setCharacterEncoding("UTF-8");
%>
<%
    String url = null;
    int currentPage = 1;
    int lineSize = 5;
    String column = null;
    String keyWord = null;
    int allRecorders = 0;
    int pageSize = 1;
    int lsData [] = new int[] {1,3,5,10,15,20,30,50,100};
%>
<%
    try {
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }catch (Exception e){}
    try {
        allRecorders = Integer.parseInt(request.getParameter("allRecorders"));
    }catch (Exception e){}
    try {
        lineSize = Integer.parseInt(request.getParameter("lineSize"));
    }catch (Exception e){}
    keyWord = request.getParameter("keyWord");
    column = request.getParameter("column");
    url = request.getParameter("url");
%>
<%
    if (allRecorders > 0){
        pageSize = (allRecorders + lineSize - 1)/ lineSize;
    }else{
        pageSize = 1;
    }
%>
<script type="text/javascript">
    function goSplit(vcp) { //vcp传递cp参数
        var eleLs = document.getElementById("lsSel").value;
        try {
            var eleKw = document.getElementById("kw").value;
            var eleCol = document.getElementById("colSel").value;
            window.location = "<%=url%>?cp=" + vcp + "&ls=" + eleLs + "&kw=" + eleKw + "&col=" + eleCol;
        }catch(Exception){
            window.location = "<%=url%>?cp=" + vcp + "&ls=" + eleLs;
        }
    }
</script>
<div>
    <button onclick="goSplit(1)" <%= currentPage <= 1? "disabled" : ""%>>首页</button>
    <button onclick="goSplit(<%=currentPage - 1%>)" <%= currentPage <= 1? "disabled" : ""%>>上一页</button>
    <button onclick="goSplit(<%=currentPage + 1%>)" <%= currentPage >= pageSize?"disabled":""%>>下一页</button>
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
</body>
</html>