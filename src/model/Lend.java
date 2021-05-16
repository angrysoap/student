package model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Lend {
    private String isbn;
    private String title;
    private Integer price;
    private String name;

    public Lend(){}
    public Lend(String isbn,String title,Integer price,String name)
    {this.isbn=isbn;this.title=title;this.price=price;this.name=name;}
    @Id
    @Column(name = "isbn", nullable = false, length = 30)
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 30)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lend lend = (Lend) o;
        return Objects.equals(isbn, lend.isbn) &&
                Objects.equals(title, lend.title) &&
                Objects.equals(price, lend.price) &&
                Objects.equals(name, lend.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, price, name);
    }
}
