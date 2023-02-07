package org.example;

import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "book")
public class Book {


    private boolean isAvailable;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    private Author author;

    private String ISBN;



    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @MapsId("id")
    private List<Store> storeList;

    @OneToMany
    @JoinTable(name = "stock",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "store_id")
    )
    private List<Store> inStockAt;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public  boolean isAvailable() {
        return isAvailable;
    }

    public  void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", ISBN='" + ISBN + '\'' +
                ", available=" + isAvailable +
                ", storeList=" + storeList +
                ", inStockAt=" + inStockAt +
                '}';
    }

    public Book() {
    }


    public Book(Long id, String title, Author author, String ISBN, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = available;
    }
}
