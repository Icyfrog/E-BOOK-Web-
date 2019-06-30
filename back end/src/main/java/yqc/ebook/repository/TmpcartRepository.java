package yqc.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import yqc.ebook.entity.Tmpcart;
public interface TmpcartRepository extends JpaRepository<Tmpcart, Integer> {
    Iterable<Tmpcart> findAllByOrderuseremailAndCancledAndPaid(String email, Integer can, Integer paid);
}
