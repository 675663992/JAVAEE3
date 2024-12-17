package BS.dao;

import BS.model.Business;
import BS.model.Food;
import BS.model.OrderDetailet;
import BS.model.Orders;
import BS.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    public int createOrders(String userId, Integer businessId, Integer daId, double orderTotal) {
        String sql = "INSERT INTO orders (userId, businessId, daId, orderTotal, orderDate, orderState) VALUES (?, ?, ?, ?, NOW(), 0)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, userId);
            pstmt.setInt(2, businessId);
            pstmt.setInt(3, daId);
            pstmt.setDouble(4, orderTotal);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating order failed, no rows affected.");
            }
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    sql = "SELECT * FROM cart WHERE userId = ?";
                    try (PreparedStatement pstmt2 = conn.prepareStatement(sql)) {
                        pstmt2.setString(1, userId);
                        ResultSet rs = pstmt2.executeQuery();
                        List<OrderDetailet> ordersList = new ArrayList<>();
                        while (rs.next()) {
                            OrderDetailet orderDetailet = new OrderDetailet();
                            orderDetailet.setOrderId(orderId);
                            orderDetailet.setFoodId(rs.getInt("foodId"));
                            orderDetailet.setQuantity(rs.getInt("quantity"));
                            orderDetailet.setFood(getFoodById(rs.getInt("foodId")));
                            ordersList.add(orderDetailet);
                        }
                        // Insert OrderDetailet list
                        sql = "INSERT INTO orderdetailet (orderId, foodId, quantity) VALUES (?, ?, ?)";
                        try (PreparedStatement pstmt3 = conn.prepareStatement(sql)) {
                            for (OrderDetailet detail : ordersList) {
                                pstmt3.setInt(1, detail.getOrderId());
                                pstmt3.setInt(2, detail.getFoodId());
                                pstmt3.setInt(3, detail.getQuantity());
                                pstmt3.addBatch();  //批量操作
                            }
                            pstmt3.executeBatch();
                        }
                    }
                    return orderId;
                } else {
                    throw new SQLException("Creating order failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public List<Orders> listOrdersByUserId(String userId) {
        List<Orders> ordersList = new ArrayList<>();
        String sql = "SELECT * FROM orders WHERE userId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders(
                        rs.getInt("orderId"),
                        rs.getString("userId"),
                        rs.getInt("businessId"),
                        rs.getString("orderDate"),
                        rs.getDouble("orderTotal"),
                        rs.getInt("daId"),
                        rs.getInt("orderState"),
                        getBusinessById(rs.getInt("businessId"))
                );
                // Retrieve OrderDetailet list
                ArrayList<OrderDetailet> detailList = getOrderDetailsByOrderId(orders.getOrderId());
                orders.setList(detailList);
                ordersList.add(orders);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ordersList;
    }

    public Orders getOrdersById(int orderId) {
        String sql = "SELECT * FROM orders WHERE orderId=?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            Orders orders = null;
            if (rs.next()) {
                orders = new Orders(
                        rs.getInt("orderId"),
                        rs.getString("userId"),
                        rs.getInt("businessId"),
                        rs.getString("orderDate"),
                        rs.getDouble("orderTotal"),
                        rs.getInt("daId"),
                        rs.getInt("orderState"),
                        getBusinessById(rs.getInt("businessId"))
                );
                // Retrieve OrderDetailet list
                ArrayList<OrderDetailet> detailList = getOrderDetailsByOrderId(orders.getOrderId());
                orders.setList(detailList);
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Business getBusinessById(int businessId) {
        String sql = "SELECT * FROM business WHERE businessId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, businessId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Business business = new Business();
                business.setBusinessId(rs.getInt("businessId"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
                return business;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Food getFoodById(int foodId) {
        String sql = "SELECT * FROM food WHERE foodId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, foodId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Food food = new Food(
                        rs.getInt("foodId"),        // foodId
                        rs.getString("foodName"),   // foodName
                        rs.getString("foodExplain"),// foodExplain
                        rs.getString("foodImg"),    // foodImg
                        rs.getDouble("foodPrice"),  // foodPrice
                        rs.getInt("businessId"),    // businessId
                        rs.getString("remarks")     // remarks
                );
                return food;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    private ArrayList<OrderDetailet> getOrderDetailsByOrderId(Integer orderId) {
        ArrayList<OrderDetailet> detailList = new ArrayList<>();
        String sql = "SELECT * FROM orderdetailet WHERE orderId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderDetailet detail = new OrderDetailet();
                detail.setOrderId(orderId);
                detail.setFoodId(rs.getInt("foodId"));
                detail.setQuantity(rs.getInt("quantity"));
                detail.setFood(getFoodById(rs.getInt("foodId")));
                detailList.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailList;
    }
}
