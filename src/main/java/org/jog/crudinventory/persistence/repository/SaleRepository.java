package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Integer> {
}
