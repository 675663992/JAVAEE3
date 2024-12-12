package com.ele.shiyan.controller.Address;

import com.ele.shiyan.model.DeliveryAddress;
import com.ele.shiyan.service.AddressService;
import com.ele.shiyan.service.Imp.AddressServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GetDeliveryAddressServlet", urlPatterns = {"/DeliveryAddressController/getDeliveryAddressById"})
public class GetDeliveryAddressServlet extends HttpServlet {
    private AddressService addressService = new AddressServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        Integer daId = Integer.valueOf(request.getParameter("daId"));
        DeliveryAddress deliveryAddress = addressService.getDeliveryAddressById(daId);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new com.google.gson.Gson().toJson(deliveryAddress, response.getWriter());
    }
}
