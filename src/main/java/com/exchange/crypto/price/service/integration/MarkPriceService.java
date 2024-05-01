package com.exchange.crypto.price.service.integration;

import com.exchange.crypto.data.domain.MarkPrice;
import org.springframework.data.domain.Page;

public interface MarkPriceService {
    Page<MarkPrice> getMarkPrice(int offset, int pageSize);
}
