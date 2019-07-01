package yqc.ebook.controller;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.Tmpcart;
import yqc.ebook.service.BookService;
import yqc.ebook.service.TmpcartService;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:9999")
@Controller
public class CartController {
    @Autowired
    private TmpcartService tmpcartService;
    @Autowired
    private BookService bookService;

    @GetMapping(path="/cart")
    public @ResponseBody Iterable<Tmpcart> getAllBooks(String email) {
        return tmpcartService.findAll(email, 0,0);
    }

    @PostMapping(path="/buy")
    public @ResponseBody Boolean buyBook(@RequestBody Integer id) {
        System.out.print(id);
        Optional<Tmpcart> op = tmpcartService.findById(id);
        Tmpcart tmp = op.get();
        if (tmp == null) {return false;}
        tmp.setPaid(1);
        tmpcartService.save(tmp);
        return true;
    }

    @PostMapping(path="/delete")
    public @ResponseBody Boolean deleteBook(@RequestBody Integer id) {
        Optional<Tmpcart> op = tmpcartService.findById(id);
        Tmpcart tmp = op.get();
        if (tmp == null) {return false;}
        tmp.setCancled(1);
        tmpcartService.save(tmp);
        return true;
    }

    @PostMapping(path="/addCart")
    public @ResponseBody Boolean deleteBook(@RequestBody JSONObject data) {
        Tmpcart tmpcart = new Tmpcart();
        Integer id = data.getInteger("id");
        String email = data.getString("useremail");
        Book book = bookService.findOne(id);
        tmpcart.setCancled(0);
        tmpcart.setPaid(0);
        tmpcart.setBookid(id);
        tmpcart.setBookisbn(book.getISBN());//Bookisbn(book.getISBN());
        tmpcart.setOrderuseremail(email);
        tmpcart.setBookprice(book.getPrice());
        tmpcartService.save(tmpcart);
        return true;
    }



}
