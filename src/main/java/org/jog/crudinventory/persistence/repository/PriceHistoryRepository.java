package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {

   @Query("SELECT ph FROM PriceHistory ph JOIN Prices p ON ph.prices.pricesId = p.pricesId JOIN Product pr ON pr.productId = p.product.productId WHERE pr.name = ?1")
    Page<PriceHistory> findByProductName(Pageable pageable, String productName);
}
