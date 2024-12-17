package BS.dao;

import BS.model.Business;
import BS.model.Cart;
import BS.model.Food;
import BS.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CartDao {
    public ArrayList<Cart> listCart(String userId) {
        String sql = "SELECT * FROM cart JOIN food on cart.foodId = food.foodId " +
                "JOIN business on cart.businessId = business.businessId " +
                "WHERE cart.userId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Cart> list = new ArrayList<>();
            while (rs.next()) {
                Food food = new Food();
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                String foodImg = rs.getString("foodImg");
                food.setFoodImg(foodImg != null ? foodImg : ""); // 确保foodImg不为空
                food.setFoodPrice(rs.getDouble(  "foodPrice"));

                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessImg(rs.getString("businessImg"));
                list.add(new Cart(
                        rs.getInt("cartId"),        // cartId
                        rs.getInt("foodId"),        // foodId
                        rs.getInt("businessId"),    // businessId
                        rs.getString("userId"),     // userId
                        rs.getInt("quantity"),       // quantity
                        food,
                        business
                ));
            }
            return list;
        }  catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int saveCart(String businessId, String userId, String foodId) {
        String sql = "INSERT INTO cart (foodId, userId, businessId, quantity) VALUES (?, ?, ?, 1)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, foodId);
            pstmt.setString(2, userId);
            pstmt.setString(3, businessId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int updateCart(String businessId, String userId, String foodId, String quantity) {
        String sql = "UPDATE cart SET quantity = ? where businessId = ? AND foodId= ? AND userId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, quantity);
            pstmt.setString(2, businessId);
            pstmt.setString(3, foodId);
            pstmt.setString(4, userId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int removeCart(String businessId, String userId, String foodId) {
        String sql = "DELETE FROM cart WHERE businessId = ? AND foodId= ? AND userId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, businessId);
            pstmt.setString(2, foodId);
            pstmt.setString(3, userId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
