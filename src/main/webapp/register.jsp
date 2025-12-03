<%--
  Created by IntelliJ IDEA.
  User: hanqing
  Date: 2025/12/3
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<h2>二手/失物信息平台 - 注册</h2>
<form action="register" method="post">
    用户名：<input type="text" name="username" required><br><br>
    密码：<input type="password" name="password" required><br><br>
    <input type="submit" value="注册">
</form>
<%-- 显示错误信息 --%>
<% if (request.getAttribute("errorMsg") != null) { %>
<p style="color: red;"><%= request.getAttribute("errorMsg") %></p>
<% } %>
</body>
</html>