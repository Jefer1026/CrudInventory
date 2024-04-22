package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricesRepository extends JpaRepository<Prices, Integer> {
}
