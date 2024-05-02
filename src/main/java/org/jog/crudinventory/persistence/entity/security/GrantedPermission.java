package org.jog.crudinventory.persistence.entity.security;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class GrantedPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "role_id")
    private Role role;


    @ManyToOne
    @JoinColumn(referencedColumnName = "operation_id")
    private Operation operation;
}
