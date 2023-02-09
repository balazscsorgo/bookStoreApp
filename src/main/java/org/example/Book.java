package org.example;

import jakarta.persistence.*;


import java.util.List;


@Entity
@Table(name = "book")
public class Book {

    @Column(name = "is_available")
    private boolean isAvailable;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    private String ISBN;

    @OneToMany(mappedBy = "book")
    private List<Stock> stores;

    public Book() {
    }

    public Book(boolean isAvailable, Long id, String title, Author author, String ISBN, List<Stock> stores) {
        this.isAvailable = isAvailable;
        this.id = id;
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.stores = stores;
    }

    public Book(String title, Author author, String ISBN, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isAvailable = isAvailable;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", ISBN='" + ISBN + '\'' +
                ", available=" + isAvailable +
                '}';
    }

}
