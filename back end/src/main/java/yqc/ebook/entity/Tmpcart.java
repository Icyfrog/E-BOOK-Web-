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

    private String orderisbn;

    private String orderuseremail;

    private Integer paid;

    private Integer cancled;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getOrderisbn() {
        return orderisbn;
    }

    public void setOrderisbn(String orderisbn) {
        this.orderisbn = orderisbn;
    }

    public String getOrderuseremail() {
        return orderuseremail;
    }

    public void setOrderuseremail(String orderuseremail) {
        this.orderuseremail = orderuseremail;
    }

    public Integer getPaid() {
        return paid;
    }

    public void setPaid(Integer paid) {
        this.paid = paid;
    }

    public Integer getCancled() {
        return cancled;
    }

    public void setCancled(Integer cancled) {
        this.cancled = cancled;
    }
}
