package yqc.ebook.dao;

import yqc.ebook.entity.Tmpcart;

import java.util.Optional;

public interface TmpcartDao {

    Optional<Tmpcart> findById(Integer id);

    Iterable<Tmpcart> findAllByCancledAndPaid(Integer can, Integer paid);

    Void save(Tmpcart tmp);
}