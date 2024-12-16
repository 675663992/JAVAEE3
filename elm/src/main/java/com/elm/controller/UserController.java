package com.elm.controller;

import com.elm.model.User;
import com.elm.service.Impl.UserServiceImpl;
import com.elm.service.UserService;
import jakarta.servlet.http.HttpServletRequest;


public class UserController {
    private UserService userService = new UserServiceImpl();
    public int getUserById(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return userService.getUserById(userId);
    }

    public User getUserByIdByPass(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        return userService.getUserByIdByPass(userId, password);
    }

    public int saveUser(HttpServletRequest request){
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String userName = request.getParameter("userName");
        int userSex = Integer.parseInt(request.getParameter("userSex"));
        return userService.saveUser(userId,password,userName,userSex);
    }
}
