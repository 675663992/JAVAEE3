package com.elm.service;

import com.elm.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> listCart(String userId);

    int saveCart(String businessId, String userId, String foodId);

    int updateCart(String businessId, String userId, String foodId, String quantity);

    int removeCart(String businessId, String userId, String foodId);
}
