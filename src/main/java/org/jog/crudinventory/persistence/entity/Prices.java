package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pricesId;

    @Column(columnDefinition = "DECIMAL(10,1)")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
