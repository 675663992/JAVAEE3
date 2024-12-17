package BS.service;


import BS.model.DeliveryAddress;

import java.util.List;

public interface AddressService {
    int saveDeliveryAddress(DeliveryAddress deliveryAddress);

    int updateDeliveryAddress(DeliveryAddress deliveryAddress);

    int removeDeliveryAddress(Integer daId);

    DeliveryAddress getDeliveryAddressById(Integer daId);

    List<DeliveryAddress> listDeliveryAddressByUserId(String userId);
}
