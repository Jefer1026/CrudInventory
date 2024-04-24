package org.jog.crudinventory.controller;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.ProductDTO;
import org.jog.crudinventory.persistence.entity.Product;
import org.jog.crudinventory.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {

        Page<Product> productPage = productService.findAll(pageable);

        return productPage.hasContent()
                ? ResponseEntity.ok(productPage)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer productId) {

        return productService.findById(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDTO) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createOne(productDTO));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateOne(productId, productDTO));
    }

    @PutMapping("/{productId}/disabled")
    public ResponseEntity<Product> disableProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(productService.disableOne(productId));
    }
}
