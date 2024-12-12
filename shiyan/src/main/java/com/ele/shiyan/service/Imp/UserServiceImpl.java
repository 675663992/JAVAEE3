package com.ele.shiyan.service.Imp;

import com.ele.shiyan.model.User;
import com.ele.shiyan.service.UserService;
import com.ele.shiyan.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public boolean checkUser(String userId, String password) {
        String sql = "SELECT * FROM user WHERE userId=? AND password=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean checkUserId(String userId) {
        String sql = "SELECT * FROM user WHERE userId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getUserById(String userId) {
        String sql = "SELECT * FROM user WHERE userId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void registerUser(User user) {
        String sql = "INSERT INTO user (userId, password, userName, userSex, userImg) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getUserName());
            pstmt.setInt(4, user.getUserSex());
            pstmt.setString(5, user.getUserImg());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
