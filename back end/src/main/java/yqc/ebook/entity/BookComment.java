package yqc.ebook.entity;

import javax.persistence.Id;

public class BookComment {
    @Id
    private Integer id;

    private String isbn;

    private String comment;

    private String base64;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }
}
