package yqc.ebook.service;

import org.springframework.stereotype.Service;
import yqc.ebook.entity.Orderitem;

public interface OrderitemService {
    Iterable<Orderitem> findAllByOid(Integer oid);

    Iterable<Orderitem> findAll();

    void save(Orderitem orderitem);
}
