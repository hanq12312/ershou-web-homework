package com.example.ershou.entity;

// 对应user表的实体类
public class User {
    private int userId;       // 对应user_id
    private String username;  // 对应username
    private String password;  // 对应password（加密后）

    // 无参构造（必须有，方便后续反射）
    public User() {}

    // 带参构造（注册时用）
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter和Setter（必须有，用于赋值/取值）
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}