package yqc.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yqc.ebook.dao.BookDao;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;
import yqc.ebook.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Iterable<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookDao.findByIsbn(isbn);
    }

    @Override
    public void save(Book b) {bookDao.save(b);}

    @Override
    public BookComment findCommentByIsbn(String isbn) {return bookDao.findCommentByIsbn(isbn);}

    @Override
    public void saveComment(BookComment bookComment) {bookDao.saveComment(bookComment);}
}
