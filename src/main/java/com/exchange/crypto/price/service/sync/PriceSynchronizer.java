package com.exchange.crypto.price.service.sync;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
@AllArgsConstructor
public class PriceSynchronizer {

    private final SyncGateway gateway;

    @Async
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void triggerSynchronization() throws IOException {
        gateway.synchronize();
    }
}
