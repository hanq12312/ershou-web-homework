package com.example.ershou.controller;

import com.example.ershou.entity.User;
import com.example.ershou.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

// 处理用户注册请求（注解配置URL：/register）
@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // 获取表单参数（用户名、密码）
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            // 调用业务层注册
            userService.register(new User(username, password));
            // 注册成功，跳转到发布页面
            resp.sendRedirect("publish.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            // 注册失败，回显错误信息
            req.setAttribute("errorMsg", "注册失败：用户名已存在");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }
}