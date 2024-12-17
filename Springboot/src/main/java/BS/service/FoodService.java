package BS.service;

import BS.model.Food;

import java.util.List;
public interface FoodService {
    List<Food> listFoodByBusinessId(String businessId);
}
