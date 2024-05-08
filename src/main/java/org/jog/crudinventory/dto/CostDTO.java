package org.jog.crudinventory.dto;

import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CostDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = -4966791027693723276L;

    private int productId;

    @DecimalMin(value = "0.01")
    private double cost;

    @DecimalMin(value = "0.01")
    private double transportationCost;

    private double costIva;

}
