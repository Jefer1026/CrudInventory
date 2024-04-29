package org.jog.crudinventory.service;

import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PriceHistoryService {

    Page<PriceHistory> findAll(Pageable pageable);

    Optional<PriceHistory> findById(Integer priceHistoryId);

    Page<PriceHistory> findByProductName(Pageable pageable,String productName);

    PriceHistory save(PriceHistory priceHistory);

    PriceHistory update(PriceHistory priceHistory);

    PriceHistory delete(Integer priceHistoryId);


}
