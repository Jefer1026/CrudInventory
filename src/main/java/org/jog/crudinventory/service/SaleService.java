package org.jog.crudinventory.service;

import org.jog.crudinventory.dto.SaleDTO;
import org.jog.crudinventory.persistence.entity.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SaleService {

    Page<Sale> findAll(Pageable pageable);

    Optional<Sale> findById(Integer SaleId);

    Sale createOne(SaleDTO saleDTO);

    Sale updateOne(Integer SaleId, SaleDTO saleDTO);

    void deleteOne(Integer SaleId);


}
