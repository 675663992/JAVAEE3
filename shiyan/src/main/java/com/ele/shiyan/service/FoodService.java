package com.ele.shiyan.service;

import com.ele.shiyan.model.Food;

import java.util.ArrayList;

public interface FoodService {
    ArrayList<Food> listFoodByBusinessId(String businessId);
}
