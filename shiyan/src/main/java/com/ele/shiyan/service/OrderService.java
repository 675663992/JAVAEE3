package com.ele.shiyan.service;

import com.ele.shiyan.model.Orders;

import java.util.ArrayList;

public interface OrderService {
    int createOrders(String userId, Integer businessId, Integer daId, double totalPrice);

    ArrayList<Orders> listOrdersByUserId(String userId);

    Orders getOrdersById(String orderId);
}
