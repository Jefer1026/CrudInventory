package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.CostHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CostHistoryRepository extends JpaRepository<CostHistory, Integer> {

    @Query("SELECT cp FROM CostHistory cp JOIN Costs c ON cp.costs.costId = c.costId JOIN Product p ON p.productId = c.product.productId WHERE p.name = ?1")
    Page<CostHistory> findByProductName(Pageable pageable, String productName);
}
