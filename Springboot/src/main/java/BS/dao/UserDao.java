package BS.dao;


import BS.model.User;
import BS.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public int getUserById(String userId) {
        String sql = "SELECT * FROM user WHERE userId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public User getUserByIdByPass(String userId, String password) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE userId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                user.setDelTag(rs.getInt("delTag"));
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                return user;
            }else return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int saveUser(String userId, String password, String userName, int userSex) {
        int row = 0;
        String sql = "INSERT INTO user (userId, password, userName, userSex) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            pstmt.setString(3, userName);
            pstmt.setInt(4, userSex);
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }
}
