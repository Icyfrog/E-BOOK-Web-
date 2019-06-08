package yqc.ebook.entity;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private Integer inventory;
    @Column(name="isbn")
    private String isbn;
    @Column
    private Float price;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Integer getInventory() {
            return inventory;
        }

        public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

        public String getISBN() { return isbn; }

        public void setISBN(String ISBN) { this.isbn = ISBN; }

        public Float getPrice() { return price; }

        public void setPrice(Float price) { this.price = price; }
}
