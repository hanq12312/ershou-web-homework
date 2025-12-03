package com.example.ershou.service;

import com.example.ershou.dao.UserDAO;
import com.example.ershou.dao.UserDAOImpl;
import com.example.ershou.entity.User;
import java.security.MessageDigest;
import java.sql.SQLException;

// 用户业务逻辑（处理注册+密码加密）
public class UserService {
    // 依赖UserDAO
    private UserDAO userDAO = new UserDAOImpl();

    // 密码MD5加密（防止明文存储）
    private String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(password.getBytes());
            // 把字节转成16进制字符串
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("密码加密失败", e);
        }
    }

    // 注册业务
    public void register(User user) throws SQLException {
        // 先加密密码，再存入数据库
        user.setPassword(encryptPassword(user.getPassword()));
        userDAO.addUser(user);
    }
}