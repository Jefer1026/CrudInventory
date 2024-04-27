package org.jog.crudinventory.controller;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.PricesDTO;
import org.jog.crudinventory.persistence.entity.Prices;
import org.jog.crudinventory.service.PricesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceController {

    private final PricesService pricesService;


    @GetMapping
    public ResponseEntity<Page<Prices>> getAll(Pageable pageable) {

        Page<Prices> pricesPage = pricesService.findAll(pageable);

        return pricesPage.hasContent()
                ? ResponseEntity.ok(pricesPage)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/{priceId}")
    public ResponseEntity<Prices> getById(@PathVariable Integer priceId) {
        return pricesService.findById(priceId)
                .map(ResponseEntity::ok)
                .orElseGet((() -> ResponseEntity.notFound().build()));
    }

    @PostMapping
    public ResponseEntity<Prices> createOne(@RequestBody PricesDTO pricesDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pricesService.createOne(pricesDTO));
    }

    @PutMapping("/{priceId}")
    public ResponseEntity<Prices> updateOne(@PathVariable Integer priceId,
                                            @RequestBody PricesDTO pricesDTO) {
        return ResponseEntity.ok(pricesService.updateOne(priceId, pricesDTO));
    }
}
