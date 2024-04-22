package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Costs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costId;

    private BigDecimal cost;

    private BigDecimal costIva;

    private BigDecimal transportationCost;

    private LocalDateTime costTimeStamp;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
