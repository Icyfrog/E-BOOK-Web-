package yqc.ebook.entity;
import javax.persistence.*;

@Entity
public class BookOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "order_time")
    private String orderTime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
