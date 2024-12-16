package com.elm.dao;

import com.elm.model.Business;
import com.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDao {
    public List<Business> listBusinessByOrderTypeId(String orderTypeId) {
        List<Business> list = null;
        String sql = "SELECT * FROM business WHERE orderTypeId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, orderTypeId);
            ResultSet rs = pstmt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Business(
                        rs.getInt("businessId"),                    // businessId
                        rs.getString("businessName"),               // businessName
                        rs.getString("businessAddress"),            // businessAddress
                        rs.getString("businessExplain"),            // businessExplain
                        rs.getString("businessImg"),                // businessImg
                        rs.getInt("orderTypeId"),                   // orderTypeId
                        rs.getDouble("starPrice"),                  // starPrice
                        rs.getDouble("deliveryPrice"),              // deliveryPrice
                        rs.getString("remarks")                     // remarks
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Business getBusinessById(String businessId) {
        Business business = null;
        String sql = "SELECT * FROM business WHERE businessId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, businessId);
            ResultSet rs = pstmt.executeQuery();
            business = new Business();
            while (rs.next()) {
                business = new Business(
                        rs.getInt("businessId"),                    // businessId
                        rs.getString("businessName"),               // businessName
                        rs.getString("businessAddress"),            // businessAddress
                        rs.getString("businessExplain"),            // businessExplain
                        rs.getString("businessImg"),                // businessImg
                        rs.getInt("orderTypeId"),                   // orderTypeId
                        rs.getDouble("starPrice"),                  // starPrice
                        rs.getDouble("deliveryPrice"),              // deliveryPrice
                        rs.getString("remarks")                     // remarks
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return business;
    }
}
