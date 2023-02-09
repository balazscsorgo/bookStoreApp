package org.example;


import jakarta.persistence.*;

@Entity
@Table(name = "author")
public class Stock {
    @ManyToOne
    @MapsId("storeId")
    Store store;

    @ManyToOne
    @MapsId("bookId")
    Book book;
    @EmbeddedId
    private stockId stockId;

    private int quantity;

    public Stock() {
    }

    public Stock(org.example.stockId stockId, int quantity) {
        this.stockId = stockId;
        this.quantity = quantity;
    }

    public org.example.stockId getStockId() {
        return stockId;
    }

    public void setStockId(org.example.stockId stockId) {
        this.stockId = stockId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" + "stockId=" + stockId + ", quantity=" + quantity + '}';
    }
}
