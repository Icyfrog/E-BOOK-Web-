package yqc.ebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import yqc.ebook.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByIsbn(String isbn);
}
