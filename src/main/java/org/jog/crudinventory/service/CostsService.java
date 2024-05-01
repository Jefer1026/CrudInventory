package org.jog.crudinventory.service;

import org.jog.crudinventory.dto.CostDTO;
import org.jog.crudinventory.persistence.entity.Costs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CostsService {


    Page<Costs> findAll(Pageable pageable);

    Optional<Costs> findById(Integer costId);

    Costs createOne(CostDTO costDTO);

    Costs updateOne(Integer costId, CostDTO costDTO);

    Optional<Costs> findByProductName(String productName);

    Costs UpdateByProductName(String productName, CostDTO costDTO);

}
