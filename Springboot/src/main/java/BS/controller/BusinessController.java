package BS.controller;

import BS.model.Business;
import BS.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/BusinessController")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(@RequestParam("orderTypeId") String orderTypeId) {
        return businessService.listBusinessByOrderTypeId(orderTypeId);
    }

    @PostMapping("/getBusinessById")
    public Business getBusinessById(@RequestParam("businessId") String businessId) {
        return businessService.getBusinessById(businessId);
    }
}
