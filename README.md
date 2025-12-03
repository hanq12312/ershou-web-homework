# 二手物品管理系统 - Web作业

## 项目简介
本项目是一个基于Java Web开发的二手物品管理系统，主要实现二手物品的发布、查询、交易管理等核心功能，用于完成课程Web开发作业。

## 一、系统结构设计
### 1. 技术栈
- 开发语言：Java
- Web框架：Spring Boot / SSM（根据你的实际框架修改，比如“Servlet + JSP”）
- 构建工具：Maven
- 数据库：MySQL 8.0（或你的数据库版本）
- 前端技术：HTML、CSS、JavaScript、JSP、Bootstrap（根据实际使用的技术修改）

### 2. 系统架构（MVC模式）

### 3. 核心模块
1. **用户模块**：注册、登录、个人信息修改
2. **物品模块**：二手物品发布、编辑、删除、详情查看
3. **查询模块**：按分类、关键词搜索二手物品
4. **交易模块**：下单、交易状态管理（根据你的实际功能修改）

## 二、数据库结构说明
### 核心数据表（按你的实际数据库表修改，以下为示例）
#### 1. 用户表（user）
| 字段名       | 类型         | 说明                 |
|--------------|--------------|----------------------|
| id           | INT          | 主键（自增）         |
| username     | VARCHAR(50)  | 用户名（唯一）       |
| password     | VARCHAR(100) | 密码（加密存储）     |
| real_name    | VARCHAR(50)  | 真实姓名             |
| phone        | VARCHAR(20)  | 手机号               |
| role         | VARCHAR(20)  | 角色（admin/user）   |
| create_time  | DATETIME     | 创建时间             |

#### 2. 二手物品表（goods）
| 字段名       | 类型         | 说明                 |
|--------------|--------------|----------------------|
| id           | INT          | 主键（自增）         |
| goods_name   | VARCHAR(100) | 物品名称             |
| category     | VARCHAR(50)  | 物品分类（如电子设备）|
| price        | DECIMAL(10,2)| 价格                 |
| description  | TEXT         | 物品描述             |
| user_id      | INT          | 发布者ID（关联user表）|
| status       | VARCHAR(20)  | 状态（在售/已售出）  |
| create_time  | DATETIME     | 发布时间             |

#### 3. 交易表（trade）（如果有该模块则保留，无则删除）
| 字段名       | 类型         | 说明                 |
|--------------|--------------|----------------------|
| id           | INT          | 主键（自增）         |
| goods_id     | INT          | 物品ID（关联goods表）|
| buyer_id     | INT          | 买家ID（关联user表） |
| seller_id    | INT          | 卖家ID（关联user表） |
| trade_time   | DATETIME     | 交易时间             |
| status       | VARCHAR(20)  | 交易状态（待付款/已完成）|

## 三、使用方法
### 1. 环境准备
- JDK版本：JDK 8 或 11（根据你的项目实际要求）
- 数据库：MySQL 8.0（需提前创建数据库，库名建议：`ershou_system`）
- 构建工具：Maven 3.6+（或IDE自带）
- 开发工具：IntelliJ IDEA / Eclipse

### 2. 项目运行步骤
1. **克隆仓库**：
   ```bash
   git clone https://github.com/hanq12312/ershou-web-homework.git
