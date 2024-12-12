package com.ele.shiyan.service.Imp;

import com.ele.shiyan.model.Food;
import com.ele.shiyan.service.FoodService;
import com.ele.shiyan.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodServiceImpl implements FoodService {
    @Override
    public ArrayList<Food> listFoodByBusinessId(String businessId) {
        String sql = "SELECT * FROM food WHERE businessId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, businessId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Food> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Food(
                        rs.getInt("foodId"),        // foodId
                        rs.getString("foodName"),   // foodName
                        rs.getString("foodExplain"),// foodExplain
                        rs.getString("foodImg"),    // foodImg
                        rs.getDouble("foodPrice"),  // foodPrice
                        rs.getInt("businessId"),    // businessId
                        rs.getString("remarks")     // remarks
                ));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
