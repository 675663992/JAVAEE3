package BS.service.Impl;

import BS.dao.UserDao;
import BS.model.User;
import BS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

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
