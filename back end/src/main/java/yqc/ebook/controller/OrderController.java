package yqc.ebook.controller;

import com.alibaba.fastjson.JSONObject;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.*;
import yqc.ebook.service.*;
import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "http://localhost:9999")
@RestController
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

    public @ResponseBody
    Iterable<BookOrder> getAllOrder() {
        return orderService.findAll();
    }

    @GetMapping(path = "/items")
    public @ResponseBody
    Iterable<Orderitem> getItems(Integer oid) {
        System.out.println(oid);
        return orderitemService.findAllByOid(oid);
    }

    @GetMapping(path = "/some")
    public @ResponseBody
    Iterable<BookOrder> getSomeOrder(String email) {
        return orderService.findAllByUserEmail(email);
    }

    @PostMapping(path = "/clean")
    public @ResponseBody
    String buyBook(@RequestBody String carts) {
        BookOrder bookOrder = new BookOrder();
        // 时间这种应该单独写一个函数出来的
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss ");// a为am/pm的标记
        Date date = new Date();// 获取当前时间
        String buyDate = sdf.format(date); // buyDate 就是写入数据库的时间
        bookOrder.setOrderTime(buyDate);
        // 时间这种应该单独写一个函数出来的
        List<Tmpcart> tmpcartList = JSON.parseArray(carts, Tmpcart.class);
        String email = tmpcartList.get(0).getOrderuseremail();
        bookOrder.setUserEmail(email);
        orderService.save(bookOrder);
        Integer oid = bookOrder.getId();
        System.out.println("OrderID 是 ： " + oid);
        HashMap<String, String> map = new HashMap<>();
        for (Tmpcart tmp : tmpcartList) {
            Book book = bookService.findByIsbn(tmp.getBookisbn());
            Integer inventory = book.getInventory();
            if (inventory < 1) {            // 先判断书还有没有了
                String isbn = book.getISBN();
                map.put("return", "1");      // map的第一个键值对，return:1 代表库存不足
                map.put("isbn", isbn);
                return JSON.toJSONString(map);
            }
            tmpcartService.delete(tmp);
            book.setInventory(inventory - 1);
            bookService.save(book);
            Orderitem orderitem = new Orderitem();
            orderitem.setBookid(book.getId());
            orderitem.setOrderId(oid);
            orderitem.setOrderTime(buyDate);
            orderitemService.save(orderitem);
        }
        return "ss";
    }

    @GetMapping(path = "/totalBooks")
    public @ResponseBody
    String totalBook(String beginTime, String endTime) {
        List<Obj> objl = new ArrayList();
        System.out.println(beginTime);
        HashMap<String, Integer> map = new HashMap<>();
        Iterable<Book> bookIterable = bookService.findAll();
        Iterable<Orderitem> orderitemIterable = orderitemService.findAll();
        for (Book book : bookIterable) {
            Integer num = 0;
            for (Orderitem orderitem : orderitemIterable) {
                if (beginTime.compareTo(orderitem.getOrderTime()) <= 0 &&
                        endTime.compareTo(orderitem.getOrderTime()) >= 0)
                    if (orderitem.getBookid() == book.getId()) {
                        num = num + 1;
                    }
            }
            // HashMap<String,Integer> map = new HashMap<>();
            // map.put(book.getName(),num);
            Obj obj = new Obj();
            obj.setName(book.getName());
            obj.setNum(num);
            objl.add(obj);
        }
        String ss = JSON.toJSONString(objl);
        return ss;
    }

    @PostMapping(path = "/userBooks")
    public @ResponseBody
    String userBooks(@RequestBody JSONObject data) {
        String beginTime = data.getString("beginTime");
        String endTime = data.getString("endTime");
        String email = data.getString("email");
        List<Obj> objl = new ArrayList();

        List<BookOrder> orderList = new ArrayList();
        Iterable<Book> bookIterable = bookService.findAll();
        Iterable<BookOrder> allOrderList = orderService.findAll();
        for (BookOrder i : allOrderList) {
            if (i.getUserEmail().equals(email)) {
                orderList.add(i);
            }
        }
        for (Book book : bookIterable) {
            Integer num = 0;
            for (BookOrder bo : orderList) {
                if (beginTime.compareTo(bo.getOrderTime()) <= 0 &&
                        endTime.compareTo(bo.getOrderTime()) >= 0) {
                    Integer oid = bo.getId();
                    Iterable<Orderitem> orderitemIterable = orderitemService.findAllByOid(oid);
                    for (Orderitem oi : orderitemIterable) {
                        if (oi.getBookid() == book.getId()) {
                            num = num + 1;
                        }
                    }
                }
            }
            Obj obj = new Obj();
            obj.setName(book.getName());
            obj.setNum(num);
            objl.add(obj);
        }
        String ss = JSON.toJSONString(objl);
        return ss;
    }

    @PostMapping(path = "/onesBooks")
    public @ResponseBody
    String onesBooks(@RequestBody JSONObject data) {
        String beginTime = data.getString("beginTime");
        String endTime = data.getString("endTime");
        String email = data.getString("email");
        List<Obj> objl = new ArrayList();

        List<BookOrder> orderList = new ArrayList();
        Iterable<Book> bookIterable = bookService.findAll();
        Iterable<BookOrder> allOrderList = orderService.findAll();
        for (BookOrder i : allOrderList) {
            if (i.getUserEmail().equals(email)) {
                orderList.add(i);
            }
        }
        for (Book book : bookIterable) {
            Integer num = 0;
            for (BookOrder bo : orderList) {
                if (beginTime.compareTo(bo.getOrderTime()) <= 0 &&
                        endTime.compareTo(bo.getOrderTime()) >= 0) {
                    Integer oid = bo.getId();
                    Iterable<Orderitem> orderitemIterable = orderitemService.findAllByOid(oid);
                    for (Orderitem oi : orderitemIterable) {
                        if (oi.getBookid() == book.getId()) {
                            num = num + 1;
                        }
                    }
                }
            }
            Obj obj = new Obj();
            obj.setName(book.getName());
            obj.setNum(num);
            objl.add(obj);
        }
        String ss = JSON.toJSONString(objl);
        return ss;
    }
}
