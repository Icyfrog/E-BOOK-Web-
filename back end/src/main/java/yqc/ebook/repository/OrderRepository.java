package yqc.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yqc.ebook.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByUseremail(String email);
}
