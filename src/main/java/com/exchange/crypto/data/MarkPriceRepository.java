package com.exchange.crypto.data;

import com.exchange.crypto.data.domain.MarkPrice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarkPriceRepository extends JpaRepository<MarkPrice, Long> {
    Optional<MarkPrice> findBySymbol(String symbol);
}
