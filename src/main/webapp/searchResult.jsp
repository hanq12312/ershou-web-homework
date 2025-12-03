<%--
  Created by IntelliJ IDEA.
  User: hanqing
  Date: 2025/12/3
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>搜索结果</title>
    <style>
        /* 可选：添加简单样式让表格更美观 */
        table { border-collapse: collapse; width: 80%; margin: 20px 0; }
        th, td { border: 1px solid #333; padding: 8px; text-align: center; }
        th { background-color: #f5f5f5; }
        a { color: #0066cc; text-decoration: none; margin: 0 5px; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
<h2>搜索结果</h2>

<%-- 用JSTL遍历结果集（已导入JSTL依赖，可直接使用） --%>
<c:if test="${empty productList}">
    <p>未找到匹配的物品</p>
</c:if>

<c:if test="${not empty productList}">
    <table>
        <!-- 表格头部（包含新增的“操作”列） -->
        <tr>
            <th>物品ID</th>
            <th>名称</th>
            <th>描述</th>
            <th>类型</th>
            <th>发布时间</th>
            <th>操作</th> <!-- 新增操作列 -->
        </tr>
        <!-- 遍历物品列表，每行添加修改/删除按钮 -->
        <c:forEach items="${productList}" var="product">
            <tr>
                <td>${product.productId}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.type == 1 ? '二手物品' : '失物招领'}</td>
                <td>${product.createTime}</td>
                <td>
                    <!-- 修改链接：携带物品ID跳转到修改页面 -->
                    <a href="modify?productId=${product.productId}">修改</a>
                    <!-- 删除链接：携带物品ID，点击弹出确认框 -->
                    <a href="delete?productId=${product.productId}" onclick="return confirm('确定要删除该物品吗？删除后不可恢复！')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="search.jsp">返回搜索</a>
</body>
</html>