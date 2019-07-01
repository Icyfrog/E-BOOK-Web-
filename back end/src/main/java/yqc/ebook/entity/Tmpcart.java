package yqc.ebook.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tmpcart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private Integer bookid;

    private String bookisbn;

    private Float bookprice;

    private String orderuseremail;

    private Integer paid;

    private Integer cancled;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setCancled(Integer cancled) {
        this.cancled = cancled;
    }

    public Integer getCancled() {
        return cancled;
    }

    public String getBookisbn() {
        return bookisbn;
    }

    public void setBookisbn(String isbn) {
        this.bookisbn = isbn;
    }

    public Float getBookprice() {
        return bookprice;
    }

    public void setBookprice(Float price) {
        this.bookprice = price;
    }

    public void setOrderuseremail(String orderuseremail) {
        this.orderuseremail = orderuseremail;
    }

    public String getOrderuseremail() {
        return orderuseremail;
    }
}
