package BS.controller;

import BS.model.DeliveryAddress;
import BS.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/DeliveryAddressController")
public class DeliveryAddressController {

    @Autowired
    private AddressService addressService;

    /**
     * 根据用户ID列出所有的收货地址
     */
    @PostMapping("/listDeliveryAddressByUserId")
    public List<DeliveryAddress> listDeliveryAddressByUserId(@RequestParam("userId") String userId) {
        return addressService.listDeliveryAddressByUserId(userId);
    }

    /**
     * 根据ID获取单个收货地址详情
     */
    @PostMapping("/getDeliveryAddressById")
    public DeliveryAddress getDeliveryAddressById(@RequestParam("daId") Integer daId) {
        return addressService.getDeliveryAddressById(daId);
    }

    /**
     * 删除指定ID的收货地址
     */
    @PostMapping("/removeDeliveryAddress")
    public int removeDeliveryAddress(@RequestParam("daId") Integer daId) {
        return addressService.removeDeliveryAddress(daId);
    }

    /**
     * 保存新的收货地址
     */
    @PostMapping("/saveDeliveryAddress")
    public int saveDeliveryAddress(
            @RequestParam("address") String address,
            @RequestParam("contactName") String contactName,
            @RequestParam("userId") String userId,
            @RequestParam("contactSex") Integer contactSex,
            @RequestParam("contactTel") String contactTel) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setAddress(address);
        deliveryAddress.setContactName(contactName);
        deliveryAddress.setUserId(userId);
        deliveryAddress.setContactSex(contactSex);
        deliveryAddress.setContactTel(contactTel);
        return addressService.saveDeliveryAddress(deliveryAddress);
    }

    /**
     * 更新现有收货地址信息
     */
    @PostMapping("/updateDeliveryAddress")
    public int updateDeliveryAddress(
            @RequestParam("address") String address,
            @RequestParam("contactName") String contactName,
            @RequestParam("daId") Integer daId,
            @RequestParam("contactSex") Integer contactSex,
            @RequestParam("contactTel") String contactTel) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.setAddress(address);
        deliveryAddress.setContactName(contactName);
        deliveryAddress.setDaId(daId);
        deliveryAddress.setContactSex(contactSex);
        deliveryAddress.setContactTel(contactTel);
        return addressService.updateDeliveryAddress(deliveryAddress);
    }
}
