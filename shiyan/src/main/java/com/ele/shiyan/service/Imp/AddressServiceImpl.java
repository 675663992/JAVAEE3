package com.ele.shiyan.service.Imp;

import com.ele.shiyan.model.DeliveryAddress;
import com.ele.shiyan.service.AddressService;
import com.ele.shiyan.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddressServiceImpl implements AddressService {
    @Override
    public int saveDeliveryAddress(String userId, String contactName, Integer contactSex, String contactTel, String address) {
        String sql = "INSERT INTO deliveryaddress (userId, contactName, contactSex, contactTel,address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, contactName);
            pstmt.setInt(3, contactSex);
            pstmt.setString(4, contactTel);
            pstmt.setString(5, address);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address) {
        String sql = "UPDATE deliveryaddress SET contactName = ?, contactSex = ?, contactTel= ?, address = ? WHERE daId = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contactName);
            pstmt.setInt(2, contactSex);
            pstmt.setString(3, contactTel);
            pstmt.setString(4, address);
            pstmt.setInt(5, daId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        String sql = "DELETE FROM deliveryaddress WHERE daId = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, daId);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        String sql = "SELECT * FROM deliveryaddress WHERE daId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, daId);
            ResultSet rs = pstmt.executeQuery();
            DeliveryAddress deliveryAddress = null;
            if (rs.next()) {
                deliveryAddress = new DeliveryAddress(
                        rs.getInt("daId"),          // daId
                        rs.getString("contactName"),// contactName
                        rs.getInt("contactSex"),    // contactSex
                        rs.getString("contactTel"), // contactTel
                        rs.getString("address"),    // address
                        rs.getString("userId")      // userId
                );
            }
            return deliveryAddress;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        String sql = "SELECT * FROM deliveryaddress WHERE userId=?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            ArrayList<DeliveryAddress> list = new ArrayList<>();
            while (rs.next()) {
                list.add(new DeliveryAddress(
                        rs.getInt("daId"),          // daId
                        rs.getString("contactName"),// contactName
                        rs.getInt("contactSex"),    // contactSex
                        rs.getString("contactTel"), // contactTel
                        rs.getString("address"),    // address
                        rs.getString("userId")      // userId
                ));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
