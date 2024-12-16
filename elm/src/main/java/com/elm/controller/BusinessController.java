package com.elm.controller;

import com.elm.model.Business;
import com.elm.service.BusinessService;
import com.elm.service.Impl.BusinessServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class BusinessController {
    private BusinessService businessService = new BusinessServiceImpl();
    public Business getBusinessById(HttpServletRequest request){
        String businessId = request.getParameter("businessId");
        return businessService.getBusinessById(businessId);
    }

    public List<Business> listBusinessByOrderTypeId(HttpServletRequest request){
        String orderTypeId = request.getParameter("orderTypeId");
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }
}
