package yqc.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.*;
import yqc.ebook.service.*;
import com.alibaba.fastjson.JSON;

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
    @Autowired
    OrderitemService orderitemService;

    @GetMapping(path = "/all")

    public @ResponseBody Iterable<BookOrder> getAllOrder() {
        return orderService.findAll();
    }

    @GetMapping(path = "/items")
    public @ResponseBody Iterable<Orderitem> getItems(Integer oid) {
        System.out.println(oid);
        return orderitemService.findAllByOid(oid);
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
        Integer oid = bookOrder.getId();
        System.out.println("OrderID 是 ： "+ oid);
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
            tmpcartService.delete(tmp);
            book.setInventory(inventory - 1);
            bookService.save(book);
            Orderitem orderitem = new Orderitem();
            orderitem.setBookid(book.getId());
            orderitem.setOrderId(oid);
            orderitemService.save(orderitem);
        }
        return "ss";
    }

}
