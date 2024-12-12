package com.ele.shiyan.controller.Person;

import com.ele.shiyan.model.User;
import com.ele.shiyan.service.Imp.UserServiceImpl;
import com.ele.shiyan.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/UserController/saveUser"})
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        String userSexStr = request.getParameter("userSex");

        int userSex = 1; // 默认值为男性
        if (userSexStr != null && !userSexStr.isEmpty()) {
            try {
                userSex = Integer.parseInt(userSexStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                response.getWriter().write("Invalid user sex value");
                return;
            }
        }

        if (!userService.checkUserId(userId)) {
            User newUser = new User(userId, password, userName, userSex);
            userService.registerUser(newUser);
            response.getWriter().write("1"); // 返回字符串"1"表示注册成功
        } else {
            response.getWriter().write("0"); // 返回字符串"0"表示注册失败，用户ID已存在
        }
    }
}
