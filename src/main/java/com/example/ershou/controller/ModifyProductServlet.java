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

@WebServlet("/modify")
public class ModifyProductServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取要修改的物品ID
        int productId = Integer.parseInt(req.getParameter("productId"));
        // （注：实际需先查询物品信息回显，此处简化）
        req.setAttribute("productId", productId);
        req.getRequestDispatcher("modify.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        // 2. 获取修改后的参数
        int productId = Integer.parseInt(req.getParameter("productId"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int type = Integer.parseInt(req.getParameter("type"));

        try {
            Product product = new Product();
            product.setProductId(productId);
            product.setName(name);
            product.setDescription(description);
            product.setType(type);
            // 3. 调用业务层修改
            productService.updateProduct(product);
            resp.sendRedirect("search.jsp"); // 修改后跳回搜索页
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "修改失败");
            req.getRequestDispatcher("modify.jsp").forward(req, resp);
        }
    }
}