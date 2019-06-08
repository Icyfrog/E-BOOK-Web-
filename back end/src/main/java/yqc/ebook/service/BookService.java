package yqc.ebook.service;

import yqc.ebook.entity.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void save(Book b);
}
