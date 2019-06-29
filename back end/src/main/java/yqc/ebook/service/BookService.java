package yqc.ebook.service;

import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;

public interface BookService {

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void save(Book b);

    BookComment findCommentByIsbn(String isbn);

    void saveComment(BookComment bookComment);
}
