package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.ProductDTO;
import org.jog.crudinventory.exception.ObjectNofFoundException;
import org.jog.crudinventory.exception.ObjectRepeatedException;
import org.jog.crudinventory.persistence.entity.Category;
import org.jog.crudinventory.persistence.entity.Product;
import org.jog.crudinventory.persistence.repository.ProductRepository;
import org.jog.crudinventory.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAllByStatus(pageable, Product.ProductStatus.ENABLED);
    }

    @Override
    public Optional<Product> findById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public Product createOne(ProductDTO productDTO) {

        if (ifExist(productDTO)) {
            System.out.println("true");
            throw new ObjectRepeatedException("Product already exists");
        } else {
            Product product = new Product();
            product.setName(productDTO.getName().toUpperCase());
            product.setStatus(Product.ProductStatus.ENABLED);

            Category category = new Category();
            category.setCategoryId(productDTO.getCategoryId());

            product.setCategory(category);
            return productRepository.save(product);

        }

    }

    @Override
    public Product updateOne(Integer productId, ProductDTO productDTO) {

        Product productFromDB = getProductNotFound(productId);
        productFromDB.setName(productDTO.getName().toUpperCase());

        Category category = new Category();
        category.setCategoryId(productDTO.getCategoryId());
        productFromDB.setCategory(category);


        return productRepository.save(productFromDB);
    }

    @Override
    public Product disableOne(Integer productId) {
        Product productFromDB = getProductNotFound(productId);
        productFromDB.setStatus(Product.ProductStatus.DISABLED);
        return productRepository.save(productFromDB);
    }

    @Override
    public Product enableOne(Integer productId) {
        Product productFromDB = getProductNotFound(productId);
        productFromDB.setStatus(Product.ProductStatus.ENABLED);
        return productRepository.save(productFromDB);
    }

    private Product getProductNotFound(Integer productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ObjectNofFoundException("Product not found"));
    }

    private boolean ifExist(ProductDTO productDTO) {
        return productRepository.findAll().stream()
                .anyMatch(product -> product.getName().equals(productDTO.getName().toUpperCase()));

    }


}
