package org.jog.crudinventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter

public class PricesDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4182028834527923540L;

    private double price;
    private Integer productId;
}
