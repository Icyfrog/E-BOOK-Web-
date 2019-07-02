package yqc.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yqc.ebook.entity.Orderitem;

public interface OrderItemReposity extends JpaRepository<Orderitem,Integer> {
    Iterable<Orderitem> findAllByOrderId(Integer oid);
}
