package com.elm.controller;

import com.elm.model.DeliveryAddress;
import com.elm.service.AddressService;
import com.elm.service.Impl.AddressServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

public class DeliveryAddressController {
    private AddressService addressService = new AddressServiceImpl();

    public List<DeliveryAddress> listDeliveryAddressByUserId(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return addressService.listDeliveryAddressByUserId(userId);
    }

    public DeliveryAddress getDeliveryAddressById(HttpServletRequest request){
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        return addressService.getDeliveryAddressById(daId);
    }

    public int removeDeliveryAddress(HttpServletRequest request){
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        return addressService.removeDeliveryAddress(daId);
    }

    public int saveDeliveryAddress(HttpServletRequest request){
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setAddress(request.getParameter("address"));
        deliveryAddress.setContactName(request.getParameter("contactName"));
        deliveryAddress.setUserId(request.getParameter("userId"));
        deliveryAddress.setContactSex(Integer.valueOf(request.getParameter("contactSex")));
        deliveryAddress.setContactTel(request.getParameter("contactTel"));
        return addressService.saveDeliveryAddress(deliveryAddress);
    }

    public int updateDeliveryAddress(HttpServletRequest request){
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setAddress(request.getParameter("address"));
        deliveryAddress.setContactName(request.getParameter("contactName"));
        deliveryAddress.setDaId(Integer.valueOf(request.getParameter("daId")));
        deliveryAddress.setContactSex(Integer.valueOf(request.getParameter("contactSex")));
        deliveryAddress.setContactTel(request.getParameter("contactTel"));
        return addressService.updateDeliveryAddress(deliveryAddress);
    }

}
