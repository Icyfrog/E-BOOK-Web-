package yqc.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.Book;
import yqc.ebook.entity.BookOrder;
import yqc.ebook.entity.Tmpcart;
import yqc.ebook.entity.User;
import yqc.ebook.service.BookService;
import yqc.ebook.service.OrderService;
import yqc.ebook.service.TmpcartService;
import yqc.ebook.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:9999")
@Controller
@RequestMapping(path="/order")
public class OrderController {

    private Tmpcart tmpcart = new Tmpcart();

    @Autowired
    OrderService orderService;
    @Autowired
    TmpcartService tmpcartService;
    @Autowired
    BookService bookService;

    @GetMapping(path = "/all")

    public @ResponseBody Iterable<BookOrder> getAllOrder() {
        return orderService.findAll();
    }

    @GetMapping(path = "/some")

    public @ResponseBody Iterable<BookOrder> getSomeOrder(String email) {
        return orderService.findAllByUserEmail(email);
    }

    @PostMapping(path="/clean")
    public @ResponseBody String buyBook(@RequestBody String carts) {
        BookOrder bookOrder = new BookOrder();
        // 时间这种应该单独写一个函数出来的
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss ");// a为am/pm的标记
            Date date = new Date();// 获取当前时间
            String buyDate = sdf.format(date); // buyDate 就是写入数据库的时间
            bookOrder.setOrderTime(buyDate);
        // 时间这种应该单独写一个函数出来的
        List<Tmpcart> tmpcartList = JSON.parseArray(carts,Tmpcart.class);
        String email = tmpcartList.get(0).getOrderuseremail();
        bookOrder.setUserEmail(email);
        orderService.save(bookOrder);
        HashMap<String,String> map = new HashMap<>();
        for (Tmpcart tmp: tmpcartList) {
            Book book = bookService.findByIsbn(tmp.getBookisbn());
            Integer inventory = book.getInventory();
            if (inventory < 1) {            // 先判断书还有没有了
                String isbn = book.getISBN();
                map.put("return","1");      // map的第一个键值对，return:1 代表库存不足
                map.put("isbn",isbn);
                return JSON.toJSONString(map);
            }
            inventory = inventory - 1;      // ******
                                            // 到底要怎么才能实现更改一本书的信息
                                            // 然后存入数据库啊
        }
        return "ss";
    }

}
