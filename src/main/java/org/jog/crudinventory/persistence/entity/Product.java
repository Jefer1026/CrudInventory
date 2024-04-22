package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String name;


    @Enumerated(EnumType.STRING)
    private ProductStatus status;



    public static enum ProductStatus {
        ENABLED, DISABLED
    }


}
