<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wanggenshen_sx
  Date: 2016/12/26
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Show Page22</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>23
<h2>Classes List</h2>
<table class="table table-striped" border="1" cellspacing="0" cellpadding="10">
    <tr class="success">
        <th>CID</th>
        <th>CName</th>
        <th>delete</th>
    </tr>

    <s:iterator value="#request.classes" id="st">
        <tr class="danger">
            <td><s:property value="#st.cid"/></td>
            <td><s:property value="#st.cname"/></td>
            <td><a href="MyClassesAction!delete?id=<s:property value='#st.cid'/>">delete</a></td>
        </tr>
    </s:iterator>

</table>

</body>
</html>
