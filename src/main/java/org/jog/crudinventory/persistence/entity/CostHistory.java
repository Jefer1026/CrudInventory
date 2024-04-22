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
public class CostHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costHistoryId;

    private LocalDateTime costHistoryTimeStamp;

    @Column(columnDefinition = "TINYINT(1)")
    private Integer costHistoryField;

    @Column(columnDefinition = "DECIMAL(10,4)")
    private BigDecimal costHistoryPreviousValue;

    @Column(columnDefinition = "DECIMAL(10,4)")
    private BigDecimal costHistoryLaterValue;


    @ManyToOne
    @JoinColumn(name = "costs_id")
    private Costs costs;




}
