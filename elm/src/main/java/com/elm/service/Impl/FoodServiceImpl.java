package com.elm.service.Impl;

import com.elm.dao.FoodDao;
import com.elm.model.Food;
import com.elm.service.FoodService;

import java.util.List;


public class FoodServiceImpl implements FoodService {
    FoodDao foodDao = new FoodDao();
    @Override
    public List<Food> listFoodByBusinessId(String businessId) {
        return foodDao.listFoodByBusinessId(businessId);
    }
}
