package org.jog.crudinventory.service;

import org.jog.crudinventory.dto.ProductDTO;
import org.jog.crudinventory.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long productId);

    Product createOne(ProductDTO productDTO);

    Product updateOne(Long productId, ProductDTO productDTO);

    Product disableOne(Long productId);
}
