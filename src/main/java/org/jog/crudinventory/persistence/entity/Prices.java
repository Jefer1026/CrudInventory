package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prices_id")
    private Integer pricesId;

    @Column(columnDefinition = "DECIMAL(10,1)")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


}
