package com.example.ershou.entity;

import java.util.Date;

// 对应product表的实体类
public class Product {
    private int productId;    // 对应product_id
    private String name;      // 对应name
    private String description; // 对应description
    private int type;         // 对应type（1=二手 2=失物）
    private int userId;       // 对应user_id（发布者ID）
    private Date createTime;  // 对应create_time

    // 无参构造
    public Product() {}

    // 发布物品时用的带参构造
    public Product(String name, String description, int type, int userId) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.userId = userId;
    }

    // Getter和Setter
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}