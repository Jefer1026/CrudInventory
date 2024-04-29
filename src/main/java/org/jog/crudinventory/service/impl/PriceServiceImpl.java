package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.PricesDTO;
import org.jog.crudinventory.exception.ObjectNofFoundException;
import org.jog.crudinventory.persistence.entity.PriceHistory;
import org.jog.crudinventory.persistence.entity.Prices;
import org.jog.crudinventory.persistence.entity.Product;
import org.jog.crudinventory.persistence.repository.PriceHistoryRepository;
import org.jog.crudinventory.persistence.repository.PricesRepository;
import org.jog.crudinventory.service.PricesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PricesService {

    private final PricesRepository pricesRepository;
    private final PriceHistoryRepository phRepository;
    private final PriceHistoryRepository priceHistoryRepository;

    @Override
    public Page<Prices> findAll(Pageable pageable) {
        return pricesRepository.findAll(pageable);
    }

    @Override
    public Optional<Prices> findById(Integer pricesId) {
        return pricesRepository.findById(pricesId);
    }

    @Override
    public Prices createOne(PricesDTO pricesDTO) {

        Prices prices = new Prices();
        prices.setPrice(pricesDTO.getPrice());

        Product product = new Product();
        product.setProductId(pricesDTO.getProductId());

        prices.setProduct(product);

        return pricesRepository.save(prices);
    }

    @Override
    public Prices updateOne(Integer pricesId, PricesDTO pricesDTO) {

        Prices pricesFromDB = pricesRepository.findById(pricesId)
                .orElseThrow(() -> new ObjectNofFoundException("Price not found"));

        PriceHistory priceHistory = new PriceHistory();

        priceHistory.setPriceHistoryPreviousValue(pricesFromDB.getPrice());
        priceHistory.setPriceHistoryLaterValue(pricesDTO.getPrice());
        priceHistory.setPriceHistoryTimeStamp(LocalDateTime.now());
        priceHistory.setPrices(pricesFromDB);
        priceHistoryRepository.save(priceHistory);


        pricesFromDB.setPrice(pricesDTO.getPrice());

        return pricesRepository.save(pricesFromDB);
    }

    @Override
    public Optional<Prices> findPricesByName(String name) {

        return pricesRepository.findPricesByName(name);
    }
}
