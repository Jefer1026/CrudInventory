package org.jog.crudinventory.controller;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.jog.crudinventory.service.PriceHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/priceHistory")
public class PriceHistoryController {

    private final PriceHistoryService priceHistoryService;

    @GetMapping
    public ResponseEntity<Page<PriceHistory>> getAll(Pageable pageable) {

        Page<PriceHistory> priceHistoryPage = priceHistoryService.findAll(pageable);

        return priceHistoryPage.hasContent()
                ? ResponseEntity.ok(priceHistoryPage)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{priceHistoryId}")
    public ResponseEntity<PriceHistory> getById(@PathVariable int priceHistoryId) {
        return priceHistoryService.findById(priceHistoryId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<Page<PriceHistory>> search(Pageable pageable,
                                                     @PathVariable String productName) {

        Page<PriceHistory> priceHistoryPage = priceHistoryService.findByProductName(pageable,productName);

        return priceHistoryPage.hasContent()
                ? ResponseEntity.ok(priceHistoryPage)
                : ResponseEntity.notFound().build();
    }


}
