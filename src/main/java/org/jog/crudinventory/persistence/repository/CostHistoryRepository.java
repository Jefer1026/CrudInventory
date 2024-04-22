package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.CostHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostHistoryRepository extends JpaRepository<CostHistory, Long> {
}
