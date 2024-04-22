package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceHistoryId;

    private LocalDateTime priceHistoryTimeStamp;

    @Column(columnDefinition = "DECIMAL(10,4)")
    private BigDecimal priceHistoryPreviousValue;

    @Column(columnDefinition = "DECIMAL(10,4)")
    private BigDecimal priceHistoryLaterValue;

    @ManyToOne
    @JoinColumn(name = "prices_id")
    private Prices prices;

}
