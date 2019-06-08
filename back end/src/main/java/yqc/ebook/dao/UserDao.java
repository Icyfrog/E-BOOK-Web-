package yqc.ebook.dao;

import yqc.ebook.entity.User;

public interface UserDao {

    User findOne(Integer id);

    User findByEmail(String email);

    void save(User u);

    Iterable<User> findAll();

    Iterable<User> findAllByActive(Integer act);

}
