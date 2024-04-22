package org.jog.crudinventory.service;

import org.jog.crudinventory.dto.ProductDTO;
import org.jog.crudinventory.persistence.entity.Costs;
import org.jog.crudinventory.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CostsService {


    Page<Costs> findAll(Pageable pageable);

    Optional<Costs> findById(Integer costId);

    Product createOne(Costs costs);

    Product updateOne(Integer costId, Costs costs);

}
