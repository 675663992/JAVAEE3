package com.elm.controller;

import com.elm.model.Food;
import com.elm.service.FoodService;
import com.elm.service.Impl.FoodServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


public class FoodController {
    private FoodService foodService = new FoodServiceImpl();
    public List<Food> listFoodByBusinessId(HttpServletRequest request){
        String businessId = request.getParameter("businessId");
        return foodService.listFoodByBusinessId(businessId);
    }
}
