package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Costs;
import org.jog.crudinventory.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface CostsRepository extends JpaRepository<Costs, Integer> {

    @Query("SELECT c FROM Costs c JOIN Product p ON c.product.productId = p.productId WHERE p.name = ?1")
    Optional<Costs> findCostsByProduct(String product);
}
