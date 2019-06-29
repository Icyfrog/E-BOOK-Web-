package yqc.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookComment;
import yqc.ebook.service.BookService;

@CrossOrigin(origins = "http://localhost:9999")
@Controller
@RequestMapping(path="/book")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    MongoTemplate mongoTemplate;

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
    public String getBookDetail( String isbn) {
        System.out.println("qingqiud shi " + isbn + ",.....");
        //return "123123123";
        Book book =  bookService.findByIsbn(isbn);
        String ss = JSON.toJSONString(book);
        return ss;
    }


    @GetMapping(path="/comment")
    @ResponseBody
    public String getBookCommon( String isbn) {
        System.out.println("123123123 ");
        //BookComment bookComment = mongoTemplate.findOne(new Query(Criteria.where("isbn").is(isbn)));
        BookComment bookComment = bookService.findCommentByIsbn(isbn);
        return JSON.toJSONString(bookComment);
        //return "123123123";
    }


}
