package com.exchange.crypto.price.service.integration.impl;

import com.exchange.crypto.data.MarkPriceRepository;
import com.exchange.crypto.data.domain.MarkPrice;
import com.exchange.crypto.price.service.integration.MarkPriceService;
import com.exchange.crypto.util.PageableUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MarkPriceServiceImpl implements MarkPriceService {

    private final MarkPriceRepository priceRepository;
    @Override
    public Page<MarkPrice> getMarkPrice(int offset, int pageSize) {
        Pageable pageable = PageableUtil.createPageRequestUsing(offset, pageSize);
        return priceRepository.findAll(pageable);
    }
}
