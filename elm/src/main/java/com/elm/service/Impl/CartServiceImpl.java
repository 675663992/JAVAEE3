package com.elm.service.Impl;

import com.elm.model.Cart;
import com.elm.dao.CartDao;
import com.elm.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
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
