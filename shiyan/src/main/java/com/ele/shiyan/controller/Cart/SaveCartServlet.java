package com.ele.shiyan.controller.Cart;

import com.ele.shiyan.model.Cart;
import com.ele.shiyan.service.CartService;
import com.ele.shiyan.service.Imp.CartServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SaveCartServlet", urlPatterns = {"/CartController/saveCart"})
public class SaveCartServlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String businessId = request.getParameter("businessId");
        String userId = request.getParameter("userId");
        String foodId = request.getParameter("foodId");
        int row = cartService.saveCart(businessId,userId,foodId);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new com.google.gson.Gson().toJson(row, response.getWriter());
    }
}
