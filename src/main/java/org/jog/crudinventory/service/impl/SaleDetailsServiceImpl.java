package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.persistence.entity.Sale;
import org.jog.crudinventory.persistence.entity.SaleDetails;
import org.jog.crudinventory.persistence.repository.SaleDetailsRepository;
import org.jog.crudinventory.service.SaleDetailsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SaleDetailsServiceImpl implements SaleDetailsService {


    private final SaleDetailsRepository saleDetailsRepository;

    @Override
    public Page<SaleDetails> findAll(Pageable pageable) {
        Sale sale = new Sale();

        return null;
    }

    @Override
    public Optional<SaleDetails> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public SaleDetails save(SaleDetails saleDetails) {
        return null;
    }
}
