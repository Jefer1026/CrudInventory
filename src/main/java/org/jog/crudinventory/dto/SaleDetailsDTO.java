package org.jog.crudinventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SaleDetailsDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 4401771104904149970L;

    private Integer productId;
    private Integer quantity;
}
