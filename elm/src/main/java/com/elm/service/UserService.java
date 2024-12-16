package com.elm.service;

import com.elm.model.User;

public interface UserService {
    int getUserById(String userId);

    User getUserByIdByPass(String userId, String password);

    int saveUser(String userId, String password, String userName, int userSex);
}
