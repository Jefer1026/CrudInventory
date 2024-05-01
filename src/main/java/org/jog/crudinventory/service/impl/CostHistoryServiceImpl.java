package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.persistence.entity.CostHistory;
import org.jog.crudinventory.persistence.repository.CostHistoryRepository;
import org.jog.crudinventory.service.CostHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CostHistoryServiceImpl implements CostHistoryService {

    private final CostHistoryRepository costHistoryRepository;

    @Override
    public Page<CostHistory> findAll(Pageable pageable) {
        return costHistoryRepository.findAll(pageable);
    }

    @Override
    public Page<CostHistory> findByProductName(Pageable pageable, String productName) {
        return costHistoryRepository.findByProductName(pageable, productName);
    }

    @Override
    public Optional<CostHistory> findById(int id) {
        return costHistoryRepository.findById(id);
    }

    @Override
    public CostHistory save(CostHistory costHistory) {
        return costHistoryRepository.save(costHistory);
    }

    @Override
    public CostHistory update(CostHistory costHistory) {
        return costHistoryRepository.save(costHistory);
    }

    @Override
    public CostHistory delete(int costHistoryId) {
        CostHistory costHistory = costHistoryRepository.findById(costHistoryId).get();
        costHistoryRepository.delete(costHistory);
        return costHistory;
    }
}
