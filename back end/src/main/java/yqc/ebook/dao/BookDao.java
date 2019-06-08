package yqc.ebook.dao;

import yqc.ebook.entity.Book;

public interface BookDao {

    Book findOne(Integer id);

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void save(Book b);
}
