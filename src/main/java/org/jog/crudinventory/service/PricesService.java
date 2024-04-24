package org.jog.crudinventory.service;


import org.jog.crudinventory.persistence.entity.Prices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PricesService {

    Page<Prices> findAll(Pageable pageable);

    Optional<Prices> findById(Integer pricesId);

    Prices createOne(Prices prices);

    Prices updateOne(Integer pricesId, Prices prices);
}
