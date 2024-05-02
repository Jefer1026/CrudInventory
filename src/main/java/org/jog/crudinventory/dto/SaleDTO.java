package org.jog.crudinventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class SaleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -5235491943232274957L;

    private Integer customerId;
    private double total_price;

}
