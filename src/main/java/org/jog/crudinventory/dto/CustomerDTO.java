package org.jog.crudinventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4167922342008852132L;

    private int identification ;

    private String name;

    private String email;

    private String phone;
}
