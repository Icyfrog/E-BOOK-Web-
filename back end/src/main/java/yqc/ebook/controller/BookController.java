package yqc.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.Book;
import yqc.ebook.service.BookService;

@CrossOrigin(origins = "http://localhost:9999")
@Controller
@RequestMapping(path="/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping(path="/addNewBook")
    @ResponseBody
    public Boolean updateBook(@RequestBody Book book) {
        Book test = bookService.findByIsbn(book.getISBN());
        if (test == null) {
            bookService.save(book);
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping(path="/detail")
    @ResponseBody
    public Book getBookDetail( String isbn) {
        System.out.println("qingqiud shi " + isbn + ",.....");
        return bookService.findByIsbn(isbn);
    }
}
