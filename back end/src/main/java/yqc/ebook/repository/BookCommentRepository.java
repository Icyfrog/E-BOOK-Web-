package yqc.ebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import yqc.ebook.entity.BookComment;

public interface BookCommentRepository extends MongoRepository<BookComment,Integer> {

    public BookComment findByIsbn(String isbn);

}