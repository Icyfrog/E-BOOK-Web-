package yqc.ebook.service;

import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;

public interface BookService {

    Book findOne(Integer id);

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void save(Book b);

    void delete(Integer id);

    BookComment findCommentByIsbn(String isbn);

    void saveComment(BookComment bookComment);

}
