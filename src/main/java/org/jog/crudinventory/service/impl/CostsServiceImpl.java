package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.CostDTO;
import org.jog.crudinventory.exception.ObjectNofFoundException;
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

        Costs costs = new Costs();

        costs.setCost(costDTO.getCost());
        costs.setCostIva(costDTO.getCostIva());
        costs.setTransportationCost(costDTO.getTransportationCost());
        costs.setCostTimeStamp(LocalDateTime.now());

        Product product = new Product();
        product.setProductId(costDTO.getProductId());

        costs.setProduct(product);

        return costsRepository.save(costs);
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

        costsFromDB.setCost(costDTO.getCost());
        costsFromDB.setCostIva(costDTO.getCostIva());
        costsFromDB.setTransportationCost(costDTO.getTransportationCost());
        costsFromDB.setCostTimeStamp(LocalDateTime.now());


        Product product = new Product();
        product.setProductId(costDTO.getProductId());
        costsFromDB.setProduct(product);




        return costsRepository.save(costsFromDB);
    }
}
