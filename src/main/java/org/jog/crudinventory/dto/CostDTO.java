package org.jog.crudinventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CostDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4966791027693723276L;

    private int productId;

    private double cost;

    private double transportationCost;

    private double costIva;


}
