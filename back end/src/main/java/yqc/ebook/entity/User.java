package yqc.ebook.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
@NodeEntity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String email;
    @Column
    private String username;
    @Column
    private String pwd;
    @Column
    private Integer active;
    @Column
    private Integer ad;

    @Relationship(type = "FRIEND", direction = Relationship.UNDIRECTED)
    public Set<User> friends;

    public void beFriendsWith(User person) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(person);
    }

    public User(){
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getEmail() {
            return email;
        }

    public void setEmail(String mailAddress) {
        this.email = mailAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getAd() {
        return ad;
    }

    public void setAd(Integer ad) {
        this.ad = ad;
    }
}
