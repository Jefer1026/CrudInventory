package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String name;

    @Enumerated(EnumType.STRING)
    private CategoryStatus status;


    public static enum CategoryStatus {
        ENABLED, DISABLED
    }
}
