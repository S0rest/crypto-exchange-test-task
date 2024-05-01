package com.exchange.crypto.price.service.domain.impl;

import com.exchange.crypto.data.MarkPriceRepository;
import com.exchange.crypto.data.domain.MarkPrice;
import com.exchange.crypto.price.service.consumer.PriceConsumer;
import com.exchange.crypto.price.service.domain.PriceDomainService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class PriceDomainServiceImpl implements PriceDomainService {

    private final PriceConsumer priceConsumer;
    private final MarkPriceRepository priceRepository;
    @Override
    public List<MarkPrice> updateMarkPriceData() throws IOException {
        List<MarkPrice> currentPrices = priceConsumer.getCurrentPrices();
        List<MarkPrice> existingPrices = priceRepository.findAll();
        List<MarkPrice> updatedOrNewPrices = new ArrayList<>();

        for (MarkPrice price : currentPrices) {
            boolean existed = existingPrices.stream().anyMatch(exPr -> exPr.getSymbol().equals(price.getSymbol()));

            if (existed) {
                Optional<MarkPrice> existingPrice = priceRepository.findBySymbol(price.getSymbol());
                existingPrice.ifPresent(exPr -> exPr.setMarkPrice(price.getMarkPrice()));
                existingPrice.ifPresent(priceRepository::save);
            } else {
                updatedOrNewPrices.add(price);
            }
        }
        priceRepository.saveAll(updatedOrNewPrices);

        return currentPrices;
    }
}
