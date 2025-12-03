package com.example.ershou.service;

import com.example.ershou.dao.ProductDAO;
import com.example.ershou.dao.ProductDAOImpl;
import com.example.ershou.entity.Product;
import java.sql.SQLException;
import java.util.List;

// 物品业务逻辑
public class ProductService {
    // 依赖ProductDAO
    private ProductDAO productDAO = new ProductDAOImpl();

    // 发布物品
    public void publishProduct(Product product) throws SQLException {
        productDAO.addProduct(product);
    }

    // 模糊搜索物品
    public List<Product> searchProduct(String keyword) throws SQLException {
        return productDAO.searchProduct(keyword);
    }

    // 修改物品
    public void updateProduct(Product product) throws SQLException {
        productDAO.updateProduct(product);
    }

    // 删除物品
    public void deleteProduct(int productId) throws SQLException {
        productDAO.deleteProduct(productId);
    }
}