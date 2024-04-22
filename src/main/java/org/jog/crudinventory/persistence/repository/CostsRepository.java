package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Costs;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CostsRepository extends JpaRepository<Costs, Integer> {
}
