package BS.service.Impl;

import BS.dao.FoodDao;
import BS.model.Food;
import BS.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodDao foodDao;
    @Override
    public List<Food> listFoodByBusinessId(String businessId) {
        return foodDao.listFoodByBusinessId(businessId);
    }
}
