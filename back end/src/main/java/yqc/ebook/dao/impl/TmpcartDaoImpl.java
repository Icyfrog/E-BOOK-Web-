package yqc.ebook.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yqc.ebook.dao.TmpcartDao;
import yqc.ebook.entity.Tmpcart;
import yqc.ebook.repository.TmpcartRepository;

import java.util.Optional;

@Repository
public class TmpcartDaoImpl implements TmpcartDao {
    @Autowired
    private TmpcartRepository tmpcartRepository;

    @Override
    public Optional<Tmpcart> findById(Integer id) {
        return tmpcartRepository.findById(id);
    }

    @Override
    public Iterable<Tmpcart> findAll(String email, Integer can, Integer paid) {
        return tmpcartRepository.findAllByOrderuseremailAndCancledAndPaid(email, can, paid);
    }

    public Void save(Tmpcart tmp) {
        tmpcartRepository.save(tmp);
        return null;
    }
}
