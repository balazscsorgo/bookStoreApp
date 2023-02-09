package org.example;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Stock {
         @EmbeddedId
        private stockId stockId;

        private int quantity;

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
        return "Stock{" +
                "stockId=" + stockId +
                ", quantity=" + quantity +
                '}';
    }

    public Stock() {
    }

    public Stock(org.example.stockId stockId, int quantity) {
        this.stockId = stockId;
        this.quantity = quantity;
    }
}
