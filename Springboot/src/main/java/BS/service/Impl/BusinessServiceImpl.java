package BS.service.Impl;

import BS.dao.BusinessDao;
import BS.model.Business;
import BS.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusinessServiceImpl implements BusinessService {
    @Autowired
    private BusinessDao businessDao;
    @Override
    public List<Business> listBusinessByOrderTypeId(String orderTypeId) {
        return businessDao.listBusinessByOrderTypeId(orderTypeId);
    }

    @Override
    public Business getBusinessById(String businessId) {
        return businessDao.getBusinessById(businessId);
    }
}
