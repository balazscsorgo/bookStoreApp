package org.example;



import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  private int quantity;

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Book> bookList;

    public Store() {
    }

    public Store(Long id, List<Book> bookList) {
        this.id = id;
    //    this.quantity = quantity;
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

/*    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
*/
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
