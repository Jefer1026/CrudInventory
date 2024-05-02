package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer priceHistoryId;

    private LocalDateTime priceHistoryTimeStamp;

    @Column(columnDefinition = "DECIMAL(10,1)")
    private double priceHistoryPreviousValue;

    @Column(columnDefinition = "DECIMAL(10,1)")
    private double priceHistoryLaterValue;

    @ManyToOne
    @JoinColumn(referencedColumnName = "prices_id")
    private Prices prices;

}
