package yqc.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yqc.ebook.dao.TmpcartDao;
import yqc.ebook.entity.Tmpcart;
import yqc.ebook.service.TmpcartService;

import java.util.Optional;

@Service
public class TmpcartServeveImpl implements TmpcartService {
    @Autowired
    private TmpcartDao tmpcartDao;

    @Override
    public Optional<Tmpcart> findById(Integer id) {
        return tmpcartDao.findById(id);
    }

    @Override
    public Iterable<Tmpcart> findAll(String email, Integer can, Integer paid) {
        return tmpcartDao.findAll(email, can, paid);
    }

    public Void save(Tmpcart tmp) {
        tmpcartDao.save(tmp);
        return null;
    }
}
