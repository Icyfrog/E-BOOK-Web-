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
import yqc.ebook.log.LogService;

@CrossOrigin(origins = "http://localhost:9999")
@RestController
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
    public String getBookDetail( Integer id) {
        //System.out.println("qingqiud shi " + isbn + ",.....");
        //return "123123123";
        Book book =  bookService.findOne(id);
        String ss = JSON.toJSONString(book);
        return ss;
    }



    @GetMapping(path="/comment")
    @ResponseBody
    public String getBookCommon( Integer id) {
        System.out.println("get comment ");
        Book book = bookService.findOne(id);
        //BookComment bookComment = mongoTemplate.findOne(new Query(Criteria.where("isbn").is(isbn)));
        BookComment bookComment = bookService.findCommentByIsbn(book.getISBN());
        return JSON.toJSONString(bookComment);
        //return "123123123";
    }

    @PostMapping(path = "/alterBook")
    @ResponseBody
    public Boolean alterBook(@RequestBody JSONObject data) {
        System.out.println(data);
        Book book = bookService.findOne(data.getInteger("id"));
        book.setName(data.getString("name"));
        book.setInventory(data.getInteger("inventory"));
        book.setISBN(data.getString("isbn"));
        book.setAuthor(data.getString("author"));
        book.setPrice(data.getFloat("price"));
        bookService.save(book);
        return true;
    }


    @PostMapping(path="/testBook")
    @ResponseBody
    public Boolean updateTest() {
        Integer id = 30;
        Book test = bookService.findOne(id);
        System.out.println("id是" + id);
        test.setInventory(2019);
        System.out.println(test);
        bookService.save(test);
        return true;
    }

    @PostMapping(path = "/deleteBook")
    @ResponseBody
    public Boolean deleteBook(@RequestBody JSONObject data) {
        System.out.println(data);
        Book book1 = bookService.findOne(data.getInteger("id"));
        if (book1 != null) {bookService.delete(book1.getId()); System.out.println("删除！！！");}
        return true;
    }

    @PostMapping(path = "/setpic")
    @ResponseBody
    public Boolean setPic(@RequestBody JSONObject data) {
        Integer id = data.getInteger("id");
        System.out.println(id);
        System.out.println("64收到了");
        Book book = bookService.findOne(id);
        String isbn = book.getISBN();
        BookComment bookComment = new BookComment();
        bookComment.setIsbn(isbn);
        bookComment.setId(id);
        bookComment.setBase64(data.getString("base64"));
        bookComment.setComment("Nothing");
        bookService.saveComment(bookComment);
        return true;
    }
}
