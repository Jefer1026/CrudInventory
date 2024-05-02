package org.jog.crudinventory.service;

import org.jog.crudinventory.persistence.entity.SaleDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface SaleDetailsService {

    Page<SaleDetails> findAll(Pageable pageable);

    Optional<SaleDetails> findById(Integer id);

    SaleDetails save(SaleDetails saleDetails);
}
