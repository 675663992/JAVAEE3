package com.elm.controller;

import com.elm.model.Cart;
import com.elm.service.CartService;
import com.elm.service.Impl.CartServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class CartController {
    private CartService cartService = new CartServiceImpl();

    public List<Cart> listCart(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return cartService.listCart(userId);
    }

    public int removeCart(HttpServletRequest request){
        String businessId = request.getParameter("businessId");
        String userId = request.getParameter("userId");
        String foodId = request.getParameter("foodId");
        return cartService.removeCart(businessId,userId,foodId);
    }

    public int saveCart(HttpServletRequest request){
        String businessId = request.getParameter("businessId");
        String userId = request.getParameter("userId");
        String foodId = request.getParameter("foodId");
        return cartService.saveCart(businessId,userId,foodId);
    }

    public int updateCart(HttpServletRequest request) {
        String businessId = request.getParameter("businessId");
        String userId = request.getParameter("userId");
        String foodId = request.getParameter("foodId");
        String quantity = request.getParameter("quantity");
        return cartService.updateCart(businessId, userId, foodId, quantity);
    }
}
