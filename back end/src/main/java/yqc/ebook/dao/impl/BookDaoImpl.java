package yqc.ebook.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yqc.ebook.dao.BookDao;
import yqc.ebook.entity.Book;
import yqc.ebook.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findOne(Integer id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Iterable<Book> findAll() {return bookRepository.findAll();}

    @Override
    public Book findByIsbn(String isbn) {return bookRepository.findByIsbn(isbn);}

    @Override
    public void save(Book b) {bookRepository.save(b);}
}
