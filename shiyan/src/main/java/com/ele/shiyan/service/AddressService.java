package com.ele.shiyan.service;

import com.ele.shiyan.model.DeliveryAddress;

import java.util.ArrayList;

public interface AddressService {
    int saveDeliveryAddress(String userId, String contactName, Integer contactSex, String contactTel, String address);

    int updateDeliveryAddress(Integer daId, String contactName, Integer contactSex, String contactTel, String address);

    int removeDeliveryAddress(Integer daId);

    DeliveryAddress getDeliveryAddressById(Integer daId);

    ArrayList<DeliveryAddress> listDeliveryAddressByUserId(String userId);
}
