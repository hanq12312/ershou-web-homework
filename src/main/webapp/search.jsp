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
  <title>搜索物品</title>
</head>
<body>
<h2>二手/失物信息平台 - 搜索物品</h2>
<form action="search" method="get">
  搜索关键词：<input type="text" name="keyword" required>
  <input type="submit" value="搜索">
</form>
<% if (request.getAttribute("errorMsg") != null) { %>
<p style="color: red;"><%= request.getAttribute("errorMsg") %></p>
<% } %>
</body>
</html>
