package yqc.ebook.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yqc.ebook.dao.OrderDao;
import yqc.ebook.entity.Order;
import yqc.ebook.entity.Orderitem;
import yqc.ebook.repository.OrderItemRepository;
import yqc.ebook.repository.OrderRepository;

@Repository
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    @Override
    public Order findByEmail(String email) {
        return orderRepository.findByUseremail(email);
    }

    @Override
    public Iterable<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Orderitem> findAllOrderItem() {
        return orderItemRepository.findAll();
    }

    @Override
    public Orderitem findByOrderId(Integer orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

}
