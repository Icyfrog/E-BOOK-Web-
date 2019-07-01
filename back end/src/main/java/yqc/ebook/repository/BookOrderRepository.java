package yqc.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yqc.ebook.entity.BookOrder;

public interface BookOrderRepository extends JpaRepository<BookOrder,Integer> {

    Iterable<BookOrder> findAllByUserEmail(String email);
}
