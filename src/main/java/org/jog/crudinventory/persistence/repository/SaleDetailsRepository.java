package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDetailsRepository extends JpaRepository<SaleDetails, Integer> {
}
