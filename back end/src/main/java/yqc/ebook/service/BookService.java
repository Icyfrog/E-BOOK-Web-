package yqc.ebook.service;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;

import java.io.BufferedReader;
import java.io.IOException;

public interface BookService {

    Book findOne(Integer id);

    Iterable<Book> findAll();

    Book findByIsbn(String isbn);

    void save(Book b);

    void transactionTestRequired();

    void transactionTestRequires_new();

    void transactionTestMandatory();

    void delete(Integer id);

    BookComment findCommentByIsbn(String isbn);

    void saveComment(BookComment bookComment);

    void luceneSearch(String[] args) throws IOException, ParseException;

    void doPagingSearch(BufferedReader in, IndexSearcher searcher, Query query,
                               int hitsPerPage, boolean raw, boolean interactive) throws IOException ;

}
