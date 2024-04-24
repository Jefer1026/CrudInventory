package org.jog.crudinventory.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class CostHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costHistoryId;

    @JsonFormat(pattern = "yyyy/MMM/dd HH:mm:ss")
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
