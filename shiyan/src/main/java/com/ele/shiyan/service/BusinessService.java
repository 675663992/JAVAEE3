package com.ele.shiyan.service;

import com.ele.shiyan.model.Business;

import java.util.ArrayList;

public interface BusinessService {
    ArrayList<Business> listBusinessByOrderTypeId(String orderTypeId);

    Business getBusinessById(String businessId);
}
