package org.jog.crudinventory.service;

import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PriceHistoryService {

    Page<PriceHistory> findAll(Pageable pageable);

    Page<PriceHistory> findByProductName(Pageable pageable,String productName);

    Optional<PriceHistory> findById(Integer priceHistoryId);

    PriceHistory save(PriceHistory priceHistory);

    PriceHistory update(PriceHistory priceHistory);

    PriceHistory delete(Integer priceHistoryId);


}
