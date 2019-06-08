package yqc.ebook.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import yqc.ebook.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    Iterable<User> findAllByActive(Integer active);
}

