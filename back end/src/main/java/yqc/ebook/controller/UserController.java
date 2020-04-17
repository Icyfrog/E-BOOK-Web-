package yqc.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import yqc.ebook.entity.User;
import yqc.ebook.repository.UserRepository;
import yqc.ebook.service.BookService;
import yqc.ebook.service.UserService;

import java.util.concurrent.atomic.AtomicInteger;

@CrossOrigin(origins = "http://localhost:9999")
@Controller
@RequestMapping(path="/user")
public class UserController {

    private AtomicInteger c = new AtomicInteger(0);

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping(path="/add")            // 数据库里的ID无法自动生成啊  是没有default value的。解决方法，mysql那里对ID没有设置为自加
    public boolean addNewUser(@RequestBody User n){
        User test = userService.findByEmail(n.getEmail());
        if (test == null) {
            userService.save(n);
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping(path="/loginTest")
    @ResponseBody
    public String logIn(String email, String pwd) {
        System.out.println(email);   //测试是否传入了参数
        System.out.println(pwd);   //测试是否传入了参数
        System.out.println("We got a new visitor! Total number is :" + c.incrementAndGet());
        return userService.login(email,pwd);
    }

    @GetMapping(path="/all")        // 查找所有用户
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping(path = "/lock")    // 封禁用户
    public @ResponseBody boolean setUserLock(@RequestBody String email) {
        //System.out.println("Test here");
        //System.out.println(email);
        User lock_user = userService.findByEmail(email);
        if (lock_user == null) {return false;}
        else {
            lock_user.setActive(0);
            userService.save(lock_user);
            return true;
        }
    }

    @PostMapping(path = "/unlock")
    public @ResponseBody boolean setUserUnlock(@RequestBody String email) {
        System.out.println("Test here");
        System.out.println(email);
        User lock_user = userService.findByEmail(email);
        if (lock_user == null) {return false;}
        else {
            lock_user.setActive(1);
            userService.save(lock_user);
            return true;
        }
    }

    @GetMapping(path="/login")          // 登录 question left!
    public boolean loginUser() {
        System.out.println("Test here");
        String email = "test";
        System.out.println(email);
        User lock_user = userService.findByEmail(email);
        if (lock_user != null) {
            lock_user.setActive(1);
            userService.save(lock_user);
        }
        return true;
    }

    @GetMapping(path="/allLock")        // 查找所有被封禁的用户
    public @ResponseBody Iterable<User> getAllLockedUsers() {
        return userService.findAllByActive(0);
    }
}
