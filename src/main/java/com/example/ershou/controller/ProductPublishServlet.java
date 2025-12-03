package com.example.ershou.controller;

import com.example.ershou.entity.Product;
import com.example.ershou.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

// 处理物品发布请求（URL：/publish）
@WebServlet("/publish")
public class ProductPublishServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 获取表单参数（物品名、描述、类型、发布者ID）
        // ⚠️ 这里简化处理：发布者ID暂时写死为1（实际应该从登录的Session中取）
        int userId = 1;
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int type = Integer.parseInt(req.getParameter("type"));

        try {
            // 调用业务层发布
            productService.publishProduct(new Product(name, description, type, userId));
            // 发布成功，跳转到搜索页面
            resp.sendRedirect("search.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "发布失败，请重试");
            req.getRequestDispatcher("publish.jsp").forward(req, resp);
        }
    }
}