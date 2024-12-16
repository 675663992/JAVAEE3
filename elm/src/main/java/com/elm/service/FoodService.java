package com.elm.service;

import com.elm.model.Food;

import java.util.List;

public interface FoodService {
    List<Food> listFoodByBusinessId(String businessId);
}
