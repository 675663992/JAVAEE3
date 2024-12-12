package com.ele.shiyan.controller.Business;

import com.ele.shiyan.model.Business;
import com.ele.shiyan.service.BusinessService;
import com.ele.shiyan.service.Imp.BusinessServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CheckBusinessDetailServlet", urlPatterns = {"/BusinessController/getBusinessById"})
public class CheckBusinessDetailServlet extends HttpServlet {
    private BusinessService businessService = new BusinessServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置CORS响应头
        response.setHeader("Access-Control-Allow-Origin", "http://localhost:8081");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");

        String businessId = request.getParameter("businessId");
        Business business = businessService.getBusinessById(businessId);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        new com.google.gson.Gson().toJson(business, response.getWriter());
    }
}
