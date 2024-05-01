package org.jog.crudinventory.service;

import org.jog.crudinventory.persistence.entity.CostHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CostHistoryService {

    Page<CostHistory> findAll(Pageable pageable);

    Page<CostHistory> findByProductName(Pageable pageable, String productName);

    Optional<CostHistory> findById(int id);

    CostHistory save(CostHistory costHistory);

    CostHistory update(CostHistory costHistory);

    CostHistory delete(int costHistoryId);
}
