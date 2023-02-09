package org.example;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class stockId implements Serializable {
        @Column(name = "book_id")
        Long bookId;

        @Column(name = "store_id")
        Long storeId;
}
