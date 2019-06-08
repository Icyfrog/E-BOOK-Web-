package yqc.ebook.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yqc.ebook.dao.UserDao;
import yqc.ebook.entity.User;
import yqc.ebook.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public Iterable<User> findAll() { return userRepository.findAll();}

    @Override
    public User findByEmail (String email) { return userRepository.findByEmail(email);}

    @Override
    public Iterable<User> findAllByActive(Integer act) { return userRepository.findAllByActive(act);}

    @Override
    public void save(User u) { userRepository.save(u); }
}
