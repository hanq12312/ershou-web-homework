package com.example.ershou.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 数据库连接/关闭工具类
public class DBUtil {
    // 1. 数据库配置（改成你自己的！）
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/ershou_db?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
    private static final String USER = "root";   // 你的MySQL用户名（比如root）
    private static final String PWD = "123456";  // 你的MySQL密码

    // 2. 加载驱动（只执行一次）
    static {
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 获取数据库连接
    public static Connection getConn() {
        try {
            return DriverManager.getConnection(URL, USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 4. 关闭连接（释放资源）
    public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}