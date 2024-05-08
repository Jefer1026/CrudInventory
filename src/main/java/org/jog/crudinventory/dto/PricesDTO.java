package org.jog.crudinventory.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter

public class PricesDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4182028834527923540L;

    @DecimalMin(value = "0.01")
    private double price;
    @Min(value = 1)
    private Integer productId;
}
