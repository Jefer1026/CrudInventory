package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.CostDTO;
import org.jog.crudinventory.exception.ObjectNofFoundException;
import org.jog.crudinventory.exception.ObjectRepeatedException;
import org.jog.crudinventory.persistence.entity.CostHistory;
import org.jog.crudinventory.persistence.entity.Costs;
import org.jog.crudinventory.persistence.entity.Product;
import org.jog.crudinventory.persistence.repository.CostHistoryRepository;
import org.jog.crudinventory.persistence.repository.CostsRepository;
import org.jog.crudinventory.service.CostsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CostsServiceImpl implements CostsService {

    private final CostsRepository costsRepository;
    private final CostHistoryRepository costHistoryRepository;

    @Override
    public Page<Costs> findAll(Pageable pageable) {
        return costsRepository.findAll(pageable);
    }

    @Override
    public Optional<Costs> findById(Integer costId) {
        return costsRepository.findById(costId);
    }

    @Override
    public Costs createOne(CostDTO costDTO) {

        if (ifExist(costDTO)) {
            throw new ObjectRepeatedException("Costs has already been created with this product");
        } else {
            Costs costs = new Costs();

            return getCosts(costDTO, costs);
        }


    }

    @Override
    public Costs updateOne(Integer costId, CostDTO costDTO) {

        Costs costsFromDB = costsRepository.findById(costId)
                .orElseThrow(() -> new ObjectNofFoundException("Cost not found"));

        CostHistory costHistory = new CostHistory();

        costHistory.setCostHistoryField(costDTO.getProductId());
        costHistory.setCostHistoryPreviousValue(costsFromDB.getCost());
        costHistory.setCostHistoryLaterValue(costDTO.getCost());
        costHistory.setCostHistoryTimeStamp(LocalDateTime.now());
        costHistory.setCosts(costsFromDB);

        costHistoryRepository.save(costHistory);

        return getCosts(costDTO, costsFromDB);
    }


    @Override
    public Costs UpdateByProductName(String productName, CostDTO costDTO) {


        Costs costProductName = costsRepository.findCostsByProduct(productName)
                .orElseThrow(() -> new ObjectNofFoundException("Product not found"));
        costProductName.setCostIva(costDTO.getCost() * (costDTO.getCostIva() / 100));
        costProductName.setCost(costDTO.getCost() + costProductName.getCostIva());
        costProductName.setTransportationCost(costDTO.getTransportationCost());
        costProductName.setCostTimeStamp(LocalDateTime.now());


        CostHistory costHistory = new CostHistory();

        costHistory.setCostHistoryField(costProductName.getProduct().getProductId());
        costHistory.setCostHistoryPreviousValue(costProductName.getCost());
        costHistory.setCostHistoryLaterValue(costDTO.getCost());
        costHistory.setCostHistoryTimeStamp(LocalDateTime.now());
        costHistory.setCosts(costProductName);

        costHistoryRepository.save(costHistory);


        return costsRepository.save(costProductName);

    }

    @Override
    public Optional<Costs> findByProductName(String productName) {
        return costsRepository.findCostsByProduct(productName);
    }

    private Costs getCosts(CostDTO costDTO, Costs costs) {

        costs.setCostIva(costDTO.getCost() * (costDTO.getCostIva() / 100));
        costs.setCost(costDTO.getCost() + costs.getCostIva());
        costs.setTransportationCost(costDTO.getTransportationCost());
        costs.setCostTimeStamp(LocalDateTime.now());

        Product product = new Product();
        product.setProductId(costDTO.getProductId());

        costs.setProduct(product);

        return costsRepository.save(costs);
    }

    private boolean ifExist(CostDTO costDTO) {

        return costsRepository.findAll().stream().anyMatch(costs -> costs.getProduct().getProductId().equals(costDTO.getProductId()));
    }
}
