package BS.controller;

import BS.model.Orders;
import BS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elm/OrdersController")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建新订单
     */
    @PostMapping("/createOrders")
    public int createOrders(
            @RequestParam("userId") String userId,
            @RequestParam("businessId") Integer businessId,
            @RequestParam("daId") Integer daId,
            @RequestParam("orderTotal") Double orderTotal) {
        return orderService.createOrders(userId, businessId, daId, orderTotal);
    }

    /**
     * 根据订单ID获取订单详情
     */
    @PostMapping("/getOrdersById")
    public Orders getOrdersById(@RequestParam("orderId") Integer orderId) {
        return orderService.getOrdersById(orderId);
    }

    /**
     * 根据用户ID列出所有订单
     */
    @PostMapping("/listOrdersByUserId")
    public List<Orders> listOrdersByUserId(@RequestParam("userId") String userId) {
        return orderService.listOrdersByUserId(userId);
    }
}
