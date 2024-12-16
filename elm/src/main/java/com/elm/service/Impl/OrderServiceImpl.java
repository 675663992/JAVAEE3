package com.elm.service.Impl;

import com.elm.model.Orders;
import com.elm.service.OrderService;
import com.elm.dao.OrderDao;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDao();
    @Override
    public int createOrders(String userId, Integer businessId, Integer daId, double orderTotal) {
        return orderDao.createOrders(userId, businessId, daId, orderTotal);
    }


    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return orderDao.listOrdersByUserId(userId);
    }

    @Override
    public Orders getOrdersById(int orderId) {
        return orderDao.getOrdersById(orderId);
    }
}
