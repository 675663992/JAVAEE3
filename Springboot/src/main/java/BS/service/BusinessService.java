package BS.service;
import BS.model.Business;

import java.util.List;

public interface BusinessService {
    List<Business> listBusinessByOrderTypeId(String orderTypeId);
    Business getBusinessById(String businessId);
}
