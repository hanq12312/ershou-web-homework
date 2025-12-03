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
import java.util.List;

// 处理物品搜索请求（URL：/search）
@WebServlet("/search")
public class ProductSearchServlet extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 获取搜索关键词
        String keyword = req.getParameter("keyword");

        try {
            // 调用业务层搜索
            List<Product> productList = productService.searchProduct(keyword);
            // 把搜索结果存到请求域，转发到结果页面
            req.setAttribute("productList", productList);
            req.getRequestDispatcher("searchResult.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMsg", "搜索失败，请重试");
            req.getRequestDispatcher("search.jsp").forward(req, resp);
        }
    }
}