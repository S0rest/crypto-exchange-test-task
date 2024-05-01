package com.exchange.crypto.price.service;

import com.exchange.crypto.data.domain.MarkPrice;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface PriceService {
    @GET("/fapi/v1/premiumIndex")
    Call<List<MarkPrice>> getMarkPrice();
}
