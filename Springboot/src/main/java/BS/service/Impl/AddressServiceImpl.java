package BS.service.Impl;

import BS.dao.AddressDao;
import BS.model.DeliveryAddress;
import BS.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;
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
