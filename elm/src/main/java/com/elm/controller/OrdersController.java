package com.elm.controller;

import com.elm.model.Orders;
import com.elm.service.Impl.OrderServiceImpl;
import com.elm.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class OrdersController {
    private OrderService orderService = new OrderServiceImpl();

    public int createOrders(HttpServletRequest request){
        String userId = request.getParameter("userId");
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        Double orderTotal = Double.valueOf(request.getParameter("orderTotal"));
        return orderService.createOrders(userId,businessId,daId,orderTotal);
    }

    public Orders getOrdersById(HttpServletRequest request){
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        return orderService.getOrdersById(orderId);
    }

    public List<Orders> listOrdersByUserId(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return orderService.listOrdersByUserId(userId);
    }
}
