package yqc.ebook.service;

import yqc.ebook.entity.User;

public interface UserService {

    User findByEmail(String email);

    void save(User u);

    Iterable<User> findAll();

    Iterable<User> findAllByActive(Integer act);

    String login(String email, String pwd);
}
