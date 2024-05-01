package com.exchange.crypto.price.service.domain;

import com.exchange.crypto.data.domain.MarkPrice;

import java.io.IOException;
import java.util.List;

public interface PriceDomainService {
    List<MarkPrice> updateMarkPriceData() throws IOException;
}
