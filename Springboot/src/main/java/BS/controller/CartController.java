package BS.controller;

import BS.model.Cart;
import BS.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/elm/CartController")
public class CartController {

    @Autowired
    private CartService cartService;

    /**
     * 列出用户的购物车内容
     */
    @PostMapping("/listCart")
    public List<Cart> listCart(@RequestParam("userId") String userId) {
        return cartService.listCart(userId);
    }

    /**
     * 从购物车中移除商品
     */
    @PostMapping("/removeCart")
    public int removeCart(
            @RequestParam("businessId") String businessId,
            @RequestParam("userId") String userId,
            @RequestParam("foodId") String foodId) {
        return cartService.removeCart(businessId, userId, foodId);
    }

    /**
     * 添加商品到购物车
     */
    @PostMapping("/saveCart")
    public int saveCart(
            @RequestParam("businessId") String businessId,
            @RequestParam("userId") String userId,
            @RequestParam("foodId") String foodId) {
        return cartService.saveCart(businessId, userId, foodId);
    }

    /**
     * 更新购物车中的商品数量
     */
    @PostMapping("/updateCart")
    public int updateCart(
            @RequestParam("businessId") String businessId,
            @RequestParam("userId") String userId,
            @RequestParam("foodId") String foodId,
            @RequestParam("quantity") String quantity) {
        return cartService.updateCart(businessId, userId, foodId, String.valueOf(quantity));
    }
}
