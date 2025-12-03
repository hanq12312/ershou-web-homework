package com.example.ershou.dao;

import com.example.ershou.entity.Product;
import java.sql.SQLException;
import java.util.List;

// 物品数据库操作接口
public interface ProductDAO {
    // 新增物品（发布）
    void addProduct(Product product) throws SQLException;

    // 模糊搜索物品
    List<Product> searchProduct(String keyword) throws SQLException;

    // 修改物品
    void updateProduct(Product product) throws SQLException;

    // 删除物品
    void deleteProduct(int productId) throws SQLException;
}
