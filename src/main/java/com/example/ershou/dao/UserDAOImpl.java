package com.example.ershou.dao;

import com.example.ershou.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// UserDAO的实现类（实际操作数据库）
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) throws SQLException {
        // SQL语句：插入用户
        String sql = "INSERT INTO user(username, password) VALUES (?, ?)";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.getConn(); // 获取连接
            pstmt = conn.prepareStatement(sql); // 预编译SQL
            // 给SQL参数赋值
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate(); // 执行插入
        } finally {
            DBUtil.close(conn, pstmt, null); // 关闭资源
        }
    }
}