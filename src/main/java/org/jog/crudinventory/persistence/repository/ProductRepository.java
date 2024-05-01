package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.status =?1")

    Page<Product> findAllByStatus(Pageable pageable, Product.ProductStatus status);
}
