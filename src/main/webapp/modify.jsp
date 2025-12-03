<%--
  Created by IntelliJ IDEA.
  User: hanqing
  Date: 2025/12/3
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改物品</title>
</head>
<body>
<h2>修改物品信息</h2>
<form action="modify" method="post">
    <input type="hidden" name="productId" value="${productId}">
    物品名称：<input type="text" name="name" required><br><br>
    物品描述：<textarea name="description" rows="3" cols="30"></textarea><br><br>
    物品类型：
    <input type="radio" name="type" value="1">二手物品
    <input type="radio" name="type" value="2">失物招领<br><br>
    <input type="submit" value="修改">
</form>
<% if (request.getAttribute("errorMsg") != null) { %>
<p style="color: red;"><%= request.getAttribute("errorMsg") %></p>
<% } %>
</body>
</html>
