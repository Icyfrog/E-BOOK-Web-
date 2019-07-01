package yqc.ebook.service;


import yqc.ebook.entity.BookOrder;

public interface OrderService {

    BookOrder findOne(Integer id);

    void save(BookOrder bookOrder);

    Iterable<BookOrder> findAllByUserEmail(String email);

    Iterable<BookOrder> findAll();
}
