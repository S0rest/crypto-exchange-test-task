package com.exchange.crypto.price.web;

import com.exchange.crypto.data.domain.MarkPrice;
import com.exchange.crypto.price.service.integration.MarkPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/price")
@RequiredArgsConstructor
public class PriceController {

    private final MarkPriceService markPriceService;

    @GetMapping("/markPrice")
    public ResponseEntity<Page<MarkPrice>> getMarkPrice(
            @RequestParam int offset,
            @RequestParam int pageSize
    ) {
        Page<MarkPrice> response = markPriceService.getMarkPrice(offset, pageSize);
        return ResponseEntity.ok(response);
    }
}
