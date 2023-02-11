package org.example;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

    @ManyToOne
    @MapsId("storeId")
    Store store;

    @ManyToOne
    @MapsId("bookId")
    Book book;

    @EmbeddedId
    private StockId stockId;

    private int quantity;

    public Stock() {
    }

    public Stock(StockId stockId, int quantity) {
        this.stockId = stockId;
        this.quantity = quantity;
    }

    public StockId getStockId() {
        return stockId;
    }

    public void setStockId(StockId stockId) {
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
        return "Stock{" +
            "stockId=" + stockId +
            ", quantity=" + quantity +
            '}';
    }
}
