package org.example;


import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class stockId implements Serializable {
        private Long storeId;
        private Long bookId;
}
