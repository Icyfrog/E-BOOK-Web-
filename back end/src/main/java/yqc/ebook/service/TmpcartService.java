package yqc.ebook.service;

import yqc.ebook.entity.Tmpcart;

import java.util.Optional;

public interface TmpcartService {

    Optional<Tmpcart> findById(Integer id);

    Iterable<Tmpcart> findAll(String email, Integer can, Integer paid);

    Void save(Tmpcart tmp);
}
