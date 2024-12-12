package com.ele.shiyan.service.Imp;

import com.ele.shiyan.model.Business;
import com.ele.shiyan.service.BusinessService;
import com.ele.shiyan.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BusinessServiceImpl implements BusinessService {
    @Override
    public ArrayList<Business> listBusinessByOrderTypeId(String orderTypeId) {
        String sql = "SELECT * FROM business WHERE orderTypeId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, orderTypeId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Business> list = new ArrayList<>();
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
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Business getBusinessById(String businessId) {
        String sql = "SELECT * FROM business WHERE businessId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, businessId);
            ResultSet rs = pstmt.executeQuery();
            Business business = new Business();
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
            return business;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
