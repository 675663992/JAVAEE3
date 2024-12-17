package BS.dao;

import BS.model.DeliveryAddress;
import BS.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDao {
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        int row = 0;
        String sql = "INSERT INTO deliveryaddress (userId, contactName, contactSex, contactTel,address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deliveryAddress.getUserId());
            pstmt.setString(2, deliveryAddress.getContactName());
            pstmt.setInt(3, deliveryAddress.getContactSex());
            pstmt.setString(4, deliveryAddress.getContactTel());
            pstmt.setString(5, deliveryAddress.getAddress());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        int row = 0;
        String sql = "UPDATE deliveryaddress SET contactName = ?, contactSex = ?, contactTel= ?, address = ? WHERE daId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, deliveryAddress.getContactName());
            pstmt.setInt(2, deliveryAddress.getContactSex());
            pstmt.setString(3, deliveryAddress.getContactTel());
            pstmt.setString(4, deliveryAddress.getAddress());
            pstmt.setInt(5, deliveryAddress.getDaId());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public int removeDeliveryAddress(Integer daId) {
        int row = 0;
        String sql = "DELETE FROM deliveryaddress WHERE daId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, daId);
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        DeliveryAddress deliveryAddress = null;
        String sql = "SELECT * FROM deliveryaddress WHERE daId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, daId);
            ResultSet rs = pstmt.executeQuery();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return deliveryAddress;
    }

    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        ArrayList<DeliveryAddress> list = null;
        String sql = "SELECT * FROM deliveryaddress WHERE userId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            list = new ArrayList<>();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
