package yqc.ebook.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String useremail;

    private Boolean ifpaid;

    private Boolean ifcanceled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public Boolean getIfpaid() {
        return ifpaid;
    }

    public void setIfpaid(Boolean ifpaid) {
        this.ifpaid = ifpaid;
    }

    public Boolean getIfcanceled() {
        return ifcanceled;
    }

    public void setIfcanceled(Boolean ifcanceled) {
        this.ifcanceled = ifcanceled;
    }
}
