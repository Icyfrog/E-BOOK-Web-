package yqc.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yqc.ebook.dao.UserDao;
import yqc.ebook.entity.User;
import yqc.ebook.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Iterable<User> findAll() { return userDao.findAll();}

    @Override
    public User findByEmail (String email) { return userDao.findByEmail(email);}

    @Override
    public Iterable<User> findAllByActive(Integer act) { return userDao.findAllByActive(act);}

    @Override
    public void save(User u) { userDao.save(u); }

    @Override
    public Integer login(String email, String pwd) {
        User user = userDao.findByEmail(email);
        if (user == null ) { return 2;}
        else if (user.getActive() == 0) {return 3;}
        else if (user.getPwd().equals(pwd)) {return 1;}
        else {return 2;}
    }
}
