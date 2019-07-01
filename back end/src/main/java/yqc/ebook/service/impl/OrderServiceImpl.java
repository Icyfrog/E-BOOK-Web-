package yqc.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yqc.ebook.entity.BookOrder;
import yqc.ebook.repository.BookOrderRepository;
import yqc.ebook.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    BookOrderRepository bookOrderRepository;

    @Override
    public BookOrder findOne(Integer id) {
        return bookOrderRepository.getOne(id);
    }

    @Override
    public void save(BookOrder bookOrder) {
        bookOrderRepository.save(bookOrder);
    }

    @Override
    public Iterable<BookOrder> findAll() {
        return bookOrderRepository.findAll();
    }

    @Override
    public Iterable<BookOrder> findAllByUserEmail(String email) {
        return bookOrderRepository.findAllByUserEmail(email);
    }

}
