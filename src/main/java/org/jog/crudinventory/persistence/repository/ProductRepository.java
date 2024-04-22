package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
