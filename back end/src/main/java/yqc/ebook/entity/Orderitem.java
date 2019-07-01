package yqc.ebook.entity;
import javax.persistence.*;

@Entity
public class Orderitem {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "orderid")
    private Integer orderId;

    @Column(name = "bookid")
    private Integer bookid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Integer getBookid() {
        return bookid;
    }

}
