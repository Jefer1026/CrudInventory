package org.jog.crudinventory.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -1284597003776591863L;

    private Integer id;

    @NotBlank
    private String name;

    @Min(value = 1)
    private Integer categoryId;

}
