package org.example;



import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "store")
    private List<Stock> books;

    public Store() {
    }

    public Store(Long id) {
    this.id=id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getBooks() {
        return books;
    }

    public void setBooks(List<Stock> books) {
        this.books = books;
    }
}