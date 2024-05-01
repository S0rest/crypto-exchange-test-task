package com.exchange.crypto.price.service.consumer;

import com.exchange.crypto.data.domain.MarkPrice;
import com.exchange.crypto.price.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class PriceConsumer {
    private final PriceService priceService;

    public PriceConsumer(Retrofit retrofit) {
        this.priceService = retrofit.create(PriceService.class);
    }

    public List<MarkPrice> getCurrentPrices() throws IOException {
        Call<List<MarkPrice>> call = priceService.getMarkPrice();

        Response<List<MarkPrice>> response = call.execute();

        try {
            return response.body();
        } catch (Exception ex) {
            throw new IOException("Failed to get current Mark Prices from binance api");
        }
    }
}
