package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PricesRepository extends JpaRepository<Prices, Integer> {


    @Query("SELECT p FROM Prices p JOIN Product pr ON p.product.productId = pr.productId WHERE pr.name = ?1")
    Optional<Prices> findPricesByName(String productName);
}
