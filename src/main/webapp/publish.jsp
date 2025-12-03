<%--
  Created by IntelliJ IDEA.
  User: hanqing
  Date: 2025/12/3
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>发布物品</title>
</head>
<body>
<h2>二手/失物信息平台 - 发布物品</h2>
<form action="publish" method="post">
  物品名称：<input type="text" name="name" required><br><br>
  物品描述：<textarea name="description" rows="3" cols="30"></textarea><br><br>
  物品类型：
  <input type="radio" name="type" value="1" checked>二手物品
  <input type="radio" name="type" value="2">失物招领<br><br>
  <input type="submit" value="发布">
</form>
<% if (request.getAttribute("errorMsg") != null) { %>
<p style="color: red;"><%= request.getAttribute("errorMsg") %></p>
<% } %>
</body>
</html>
