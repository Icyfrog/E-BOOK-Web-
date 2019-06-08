package yqc.ebook.dao;

import yqc.ebook.entity.Order;
import yqc.ebook.entity.Orderitem;

public interface OrderDao {

    Order findByEmail(String email);

    Iterable<Order> findAllOrder();

    Iterable<Orderitem> findAllOrderItem();

    Orderitem findByOrderId(Integer orderId);

}

