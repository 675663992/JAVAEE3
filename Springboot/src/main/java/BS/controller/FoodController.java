package BS.controller;

import BS.model.Food;
import BS.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/FoodController")
public class FoodController {

    @Autowired
    private FoodService foodService;

    /**
     * 根据商家ID列出所有食品
     */
    @PostMapping("/listFoodByBusinessId")
    public List<Food> listFoodByBusinessId(@RequestParam("businessId") String businessId) {
        return foodService.listFoodByBusinessId(businessId);
    }
}
