package org.jog.crudinventory.service;


import org.jog.crudinventory.dto.PricesDTO;
import org.jog.crudinventory.persistence.entity.Prices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PricesService {

    Page<Prices> findAll(Pageable pageable);

    Optional<Prices> findById(Integer pricesId);

    Prices createOne(PricesDTO pricesDTO);

    Prices updateOne(Integer pricesId, PricesDTO pricesDTO);
}
