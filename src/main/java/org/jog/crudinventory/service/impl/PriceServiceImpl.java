package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.persistence.entity.Prices;
import org.jog.crudinventory.persistence.entity.Product;
import org.jog.crudinventory.persistence.repository.PriceHistoryRepository;
import org.jog.crudinventory.persistence.repository.PricesRepository;
import org.jog.crudinventory.service.PricesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;
    private final PriceHistoryRepository phRepository;

    @Override
    public Page<Prices> findAll(Pageable pageable) {
        return pricesRepository.findAll(pageable);
    }

    @Override
    public Optional<Prices> findById(Integer pricesId) {
        return pricesRepository.findById(pricesId);
    }

    @Override
    public Prices createOne(Prices prices) {

        return null;
    }

    @Override
    public Prices updateOne(Integer pricesId, Prices prices) {
        return null;
    }
}
