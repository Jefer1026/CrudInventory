package org.jog.crudinventory.service.impl;

import lombok.RequiredArgsConstructor;
import org.jog.crudinventory.dto.SaleDTO;
import org.jog.crudinventory.exception.ObjectNofFoundException;
import org.jog.crudinventory.persistence.entity.Customer;
import org.jog.crudinventory.persistence.entity.Sale;
import org.jog.crudinventory.persistence.entity.SaleDetails;
import org.jog.crudinventory.persistence.repository.SaleRepository;
import org.jog.crudinventory.service.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    @Override
    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    @Override
    public Optional<Sale> findById(Integer SaleId) {
        return saleRepository.findById(SaleId);
    }

    @Override
    public Sale createOne(SaleDTO saleDTO) {



        //FINISH CREATE_ONE, I'VE GOT TO KNOW HOW TO DO IT

        Sale sale = new Sale();

        sale.setDateSale(LocalDateTime.now());

        List<SaleDetails> items = sale.getListSaleDetails();
        Customer customer = new Customer();
        customer.setId(saleDTO.getCustomerId());
        sale.setCustomer(customer);


        return saleRepository.save(sale);
    }

    @Override
    public Sale updateOne(Integer SaleId, SaleDTO saleDTO) {

        Sale sale = saleRepository.findById(SaleId)
                .orElseThrow(() -> new ObjectNofFoundException("Sale not found"));


        return null;
    }

    @Override
    public void deleteOne(Integer SaleId) {

        saleRepository.deleteById(SaleId);

    }
}
