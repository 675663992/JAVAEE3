package BS.controller;

import BS.model.User;
import BS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/elm/UserController")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户ID获取用户信息（返回用户ID）
     */
    @PostMapping("/getUserById")
    public int getUserById(@RequestParam("userId") String userId) {
        return userService.getUserById(userId);
    }

    /**
     * 根据用户ID和密码验证用户
     */
    @PostMapping("/getUserByIdByPass")
    public User getUserByIdByPass(
            @RequestParam("userId") String userId,
            @RequestParam("password") String password) {
        return userService.getUserByIdByPass(userId, password);
    }

    /**
     * 保存新用户
     */
    @PostMapping("/saveUser")
    public int saveUser(
            @RequestParam("userId") String userId,
            @RequestParam("password") String password,
            @RequestParam("userName") String userName,
            @RequestParam("userSex") int userSex) {
        return userService.saveUser(userId, password, userName, userSex);
    }
}
