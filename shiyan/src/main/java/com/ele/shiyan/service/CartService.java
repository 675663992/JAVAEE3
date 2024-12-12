package com.ele.shiyan.service;

import com.ele.shiyan.model.Business;
import com.ele.shiyan.model.Cart;

import java.util.ArrayList;

public interface CartService {
    ArrayList<Cart> listCart(String userId);

    int saveCart(String businessId, String userId, String foodId);

    int updateCart(String businessId, String userId, String foodId, String quantity);

    int removeCart(String businessId, String userId, String foodId);
}
