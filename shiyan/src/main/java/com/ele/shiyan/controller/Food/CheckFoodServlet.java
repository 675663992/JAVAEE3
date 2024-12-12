package com.ele.shiyan.controller.Food;

import com.ele.shiyan.model.Food;
import com.ele.shiyan.service.FoodService;
import com.ele.shiyan.service.Imp.FoodServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CheckFoodServlet", urlPatterns = {"/FoodController/listFoodByBusinessId"})
public class CheckFoodServlet extends HttpServlet {
    private FoodService foodService = new FoodServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String businessId = request.getParameter("businessId");
        ArrayList<Food> list = foodService.listFoodByBusinessId(businessId);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new com.google.gson.Gson().toJson(list, response.getWriter());
    }
}
