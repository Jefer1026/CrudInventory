package org.jog.crudinventory.controller;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.CostDTO;
import org.jog.crudinventory.persistence.entity.Costs;
import org.jog.crudinventory.service.CostsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/costs")
public class CostController {


    private final CostsService costsService;


    @GetMapping
    public ResponseEntity<Page<Costs>> findAll(Pageable pageable) {

        Page<Costs> costsPage = costsService.findAll(pageable);

        return costsPage.hasContent()
                ? ResponseEntity.ok(costsPage)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{costId}")
    public ResponseEntity<Costs> findById(@PathVariable Integer costId) {
        return costsService.findById(costId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Costs> save(@RequestBody CostDTO costDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(costsService.createOne(costDTO));
    }

    @PutMapping("{costId}")
    public ResponseEntity<Costs> update(@PathVariable Integer costId, @RequestBody CostDTO costDTO) {
        return ResponseEntity.ok(costsService.updateOne(costId, costDTO));
    }

    @GetMapping("/search/{productName}")
    public ResponseEntity<Costs> findByProductName(@PathVariable String productName) {
        return costsService.findByProductName(productName)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
