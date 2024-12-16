package com.elm.service.Impl;

import com.elm.model.User;
import com.elm.service.UserService;
import com.elm.dao.UserDao;


public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDao();

    @Override
    public int getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public User getUserByIdByPass(String userId, String password) {
        return userDao.getUserByIdByPass(userId, password);
    }

    @Override
    public int saveUser(String userId, String password, String userName, int userSex) {
        return userDao.saveUser(userId, password, userName, userSex);
    }
}
