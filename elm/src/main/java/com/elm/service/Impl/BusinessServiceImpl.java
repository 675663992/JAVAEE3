package com.elm.service.Impl;

import com.elm.model.Business;
import com.elm.service.BusinessService;
import com.elm.dao.BusinessDao;

import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private BusinessDao businessDao = new BusinessDao();
    @Override
    public List<Business> listBusinessByOrderTypeId(String orderTypeId) {
        return businessDao.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(String businessId) {
        return businessDao.getBusinessById(businessId);
    }
}
