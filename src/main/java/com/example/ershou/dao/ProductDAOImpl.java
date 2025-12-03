package com.example.ershou.dao;

import com.example.ershou.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// ProductDAO的实现类
public class ProductDAOImpl implements ProductDAO {
    @Override
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO product(name, description, type, user_id) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getType());
            pstmt.setInt(4, product.getUserId());
            pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt, null);
        }
    }

    @Override
    public List<Product> searchProduct(String keyword) throws SQLException {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE ? OR description LIKE ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            // 模糊匹配（%keyword%）
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            rs = pstmt.executeQuery(); // 执行查询

            // 遍历结果集，封装成Product对象
            while (rs.next()) {
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setType(rs.getInt("type"));
                product.setUserId(rs.getInt("user_id"));
                product.setCreateTime(rs.getDate("create_time"));
                productList.add(product);
            }
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }
        return productList;
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE product SET name=?, description=?, type=? WHERE product_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setInt(3, product.getType());
            pstmt.setInt(4, product.getProductId());
            pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt, null);
        }
    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        String sql = "DELETE FROM product WHERE product_id=?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        } finally {
            DBUtil.close(conn, pstmt, null);
        }
    }
}