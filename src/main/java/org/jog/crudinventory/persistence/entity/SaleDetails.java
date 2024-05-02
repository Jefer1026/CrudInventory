package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SaleDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 20)
    private Integer quantity;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double price;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double subTotal;


    @ManyToOne
    @JoinColumn(referencedColumnName = "sale_id")
    private Sale sale;

    @ManyToOne
    @JoinColumn(referencedColumnName = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(referencedColumnName = "prices_id")
    private Prices prices;
}
