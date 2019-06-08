package yqc.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yqc.ebook.entity.Orderitem;

public interface OrderItemRepository extends JpaRepository<Orderitem, Integer> {

    Orderitem findByOrderId(Integer orderId);
}
