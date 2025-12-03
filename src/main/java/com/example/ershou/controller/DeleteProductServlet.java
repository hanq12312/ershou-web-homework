package com.example.ershou.controller;

import com.example.ershou.service.ProductService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取要删除的物品ID
        int productId = Integer.parseInt(req.getParameter("productId"));
        try {
            productService.deleteProduct(productId);
            resp.sendRedirect("search.jsp"); // 删除后跳回搜索页
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write("删除失败：" + e.getMessage());
        }
    }
}