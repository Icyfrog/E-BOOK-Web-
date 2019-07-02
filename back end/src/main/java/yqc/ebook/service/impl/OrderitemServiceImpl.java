package yqc.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yqc.ebook.entity.Orderitem;
import yqc.ebook.repository.OrderItemReposity;
import yqc.ebook.service.OrderitemService;

@Service
public class OrderitemServiceImpl implements OrderitemService {

    @Autowired
    OrderItemReposity orderItemReposity;

    @Override
    public Iterable<Orderitem> findAllByOid(Integer oid) {
        return orderItemReposity.findAllByOrderId(oid);
    }

    @Override
    public void save(Orderitem orderitem) {
        orderItemReposity.save(orderitem);
    }
}
