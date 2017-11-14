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
<h2>Employee List</h2>
<table class="table table-striped" border="1" cellspacing="0" cellpadding="10">
    <tr class="success">
        <th>ID</th>
        <th>Name</th>
        <th>password</th>
    </tr>

    <s:iterator value="#request.users" id="st">
        <tr class="danger">
            <td><s:property value="#st.id"/></td>
            <td><s:property value="#st.username"/></td>
            <td><s:property value="#st.password"/></td>
        </tr>
    </s:iterator>
    <s:debug/>
</table>

</body>
</html>
