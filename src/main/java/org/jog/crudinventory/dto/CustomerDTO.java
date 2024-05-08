package org.jog.crudinventory.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CustomerDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4167922342008852132L;

    @Min(value = 1)
    private int identification ;

    @NotBlank
    private String name;

    private String email;

    private String phone;
}
