package BS.service;

import BS.model.Orders;

import java.util.List;

public interface OrderService {
    int createOrders(String userId, Integer businessId, Integer daId, double totalPrice);

    List<Orders> listOrdersByUserId(String userId);

    Orders getOrdersById(int orderId);
}
