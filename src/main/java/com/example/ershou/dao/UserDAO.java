package com.example.ershou.dao;

import com.example.ershou.entity.User;
import java.sql.SQLException;

// 用户数据库操作接口
public interface UserDAO {
    // 新增用户（注册）
    void addUser(User user) throws SQLException;
}