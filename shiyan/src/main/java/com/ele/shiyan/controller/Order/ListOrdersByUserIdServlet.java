package com.ele.shiyan.controller.Order;

import com.ele.shiyan.model.Orders;
import com.ele.shiyan.service.Imp.OrderServiceImpl;
import com.ele.shiyan.service.OrderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ListOrdersByUserIdServlet", urlPatterns = {"/OrdersController/listOrdersByUserId"})
public class ListOrdersByUserIdServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String userId = request.getParameter("userId");
        System.out.println(userId);
        ArrayList<Orders> list = orderService.listOrdersByUserId(userId);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new com.google.gson.Gson().toJson(list, response.getWriter());
    }
}

