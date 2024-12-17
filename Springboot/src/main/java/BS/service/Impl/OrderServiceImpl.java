package BS.service.Impl;

import BS.dao.OrderDao;
import BS.model.Orders;
import BS.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;
    @Override
    public int createOrders(String userId, Integer businessId, Integer daId, double orderTotal) {
        return orderDao.createOrders(userId, businessId, daId, orderTotal);
    }


    @Override
    public List<Orders> listOrdersByUserId(String userId) {
        return orderDao.listOrdersByUserId(userId);
    }

    @Override
    public Orders getOrdersById(int orderId) {
        return orderDao.getOrdersById(orderId);
    }
}
