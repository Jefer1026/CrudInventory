package org.jog.crudinventory.controller;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.persistence.entity.CostHistory;
import org.jog.crudinventory.service.CostHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costHistory")
public class CostHistoryController {

    private final CostHistoryService costHistoryService;

    @GetMapping
    public ResponseEntity<Page<CostHistory>> findAll(Pageable pageable) {

        Page<CostHistory> costHistoryPage = costHistoryService.findAll(pageable);

        return costHistoryPage.hasContent()
                ? ResponseEntity.ok(costHistoryPage)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("search/{productName}")
    public ResponseEntity<Page<CostHistory>> findByProductName(@PathVariable String productName, Pageable pageable) {
        Page<CostHistory> costHistoryPageProduct = costHistoryService.findByProductName(pageable, productName);
        return costHistoryPageProduct.hasContent()
                ? ResponseEntity.ok(costHistoryPageProduct)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{costHistoryId}")
    public ResponseEntity<CostHistory> findById(@PathVariable Integer costHistoryId) {

        return costHistoryService.findById(costHistoryId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
