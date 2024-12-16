package com.elm.service.Impl;

import com.elm.dao.AddressDao;
import com.elm.model.DeliveryAddress;
import com.elm.service.AddressService;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao = new AddressDao();
    @Override
    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        return addressDao.saveDeliveryAddress(deliveryAddress);
    }

    @Override
    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        return addressDao.updateDeliveryAddress(deliveryAddress);
    }

    @Override
    public int removeDeliveryAddress(Integer daId) {
        return addressDao.removeDeliveryAddress(daId);
    }

    @Override
    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return addressDao.getDeliveryAddressById(daId);
    }

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return addressDao.listDeliveryAddressByUserId(userId);
    }
}
