package com.exchange.crypto.price.service.sync;

import com.exchange.crypto.data.domain.MarkPrice;
import com.exchange.crypto.price.service.domain.PriceDomainService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class SyncGateway {

    private final PriceDomainService priceDomainService;

    public void synchronize() throws IOException {
        log.info("Starting sync from binance API");
        List<MarkPrice> updated = priceDomainService.updateMarkPriceData();
        log.info(String.format("Sync finished, updated prices: %s", updated.size()));
    }
}
