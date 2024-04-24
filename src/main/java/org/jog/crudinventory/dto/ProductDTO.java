package org.jog.crudinventory.dto;

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

    private String name;

    private Integer categoryId;

}
