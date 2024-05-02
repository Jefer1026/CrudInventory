package org.jog.crudinventory.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false)
    private String documentType;

    @Column(unique = true)
    private int identification;

    private String name;

    @Column(unique = true)
    private String email;

    private String phone;

}
