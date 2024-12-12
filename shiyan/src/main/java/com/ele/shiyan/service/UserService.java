package com.ele.shiyan.service;

import com.ele.shiyan.model.User;

public interface UserService {
    boolean checkUser(String userId, String password);

    User getUserById(String userId);

    boolean checkUserId(String userId);

    void registerUser(User newUser);
}
