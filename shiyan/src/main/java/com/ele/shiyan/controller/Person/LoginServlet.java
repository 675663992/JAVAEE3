package com.ele.shiyan.controller.Person;

import java.io.IOException;

import com.ele.shiyan.model.User;
import com.ele.shiyan.service.Imp.UserServiceImpl;
import com.ele.shiyan.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/UserController/getUserByIdByPass"})
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        boolean success = userService.checkUser(userId, password);
        User user = null;
        if (success) {
            user = userService.getUserById(userId);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new com.google.gson.Gson().toJson(user, response.getWriter());
    }
}
