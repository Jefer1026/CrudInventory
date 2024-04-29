package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.exception.ObjectNofFoundException;
import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.jog.crudinventory.persistence.repository.PriceHistoryRepository;
import org.jog.crudinventory.service.PriceHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceHistoryImpl implements PriceHistoryService {

    private final PriceHistoryRepository priceHistoryRepository;

    @Override
    public Page<PriceHistory> findAll(Pageable pageable) {
        return priceHistoryRepository.findAll(pageable);
    }

    @Override
    public Optional<PriceHistory> findById(Integer priceHistoryId) {
        return priceHistoryRepository.findById(priceHistoryId);
    }

   @Override
    public Page<PriceHistory> findByProductName(Pageable pageable,String productName) {
        return priceHistoryRepository.findByProductName(pageable,productName);
    }

    @Override
    public PriceHistory save(PriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }

    @Override
    public PriceHistory update(PriceHistory priceHistory) {
        return priceHistoryRepository.save(priceHistory);
    }

    @Override
    public PriceHistory delete(Integer priceHistoryId) {
        PriceHistory priceHistory = priceHistoryRepository.findById(priceHistoryId)
                .orElseThrow(() -> new ObjectNofFoundException("PriceHistory not found"));
        priceHistoryRepository.delete(priceHistory);
        return priceHistory;
    }


}
