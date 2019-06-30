package yqc.ebook.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yqc.ebook.dao.BookDao;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;
import yqc.ebook.repository.BookCommentRepository;
import yqc.ebook.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BookCommentRepository bookCommentRepository;

    @Override
    public Book findOne(Integer id) {
        return bookRepository.getOne(id);
    }

    @Override
    public Iterable<Book> findAll() {return bookRepository.findAll();}

    @Override
    public Book findByIsbn(String isbn) {return bookRepository.findByIsbn(isbn);}

    @Override
    public void save(Book b) {bookRepository.saveAndFlush(b);}

    @Override
    public void delete(Integer id) { bookRepository.deleteById(id);}

    @Override
    public BookComment findCommentByIsbn(String isbn) {return bookCommentRepository.findByIsbn(isbn);}

    @Override
    public void saveComment(BookComment bookComment) {bookCommentRepository.save(bookComment);}
}
