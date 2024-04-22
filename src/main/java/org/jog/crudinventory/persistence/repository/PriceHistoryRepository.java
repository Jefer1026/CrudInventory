package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {
}
