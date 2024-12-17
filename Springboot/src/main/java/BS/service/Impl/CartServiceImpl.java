package BS.service.Impl;

import BS.dao.CartDao;
import BS.model.Cart;
import BS.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartDao cartDao = new CartDao();
    @Override
    public List<Cart> listCart(String userId) {
        return cartDao.listCart(userId);
    }

    @Override
    public int saveCart(String businessId, String userId, String foodId) {
        return cartDao.saveCart(businessId, userId, foodId);
    }

    @Override
    public int updateCart(String businessId, String userId, String foodId, String quantity) {
        return cartDao.updateCart(businessId, userId, foodId, quantity);
    }

    @Override
    public int removeCart(String businessId, String userId, String foodId) {
        return cartDao.removeCart(businessId, userId, foodId);
    }
}
