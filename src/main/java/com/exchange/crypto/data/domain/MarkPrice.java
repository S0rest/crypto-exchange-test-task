package com.exchange.crypto.data.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = MarkPrice.TABLE)
public class MarkPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Columns.ID)
    private long id;

    @Size(max = 255)
    @Column(name = Columns.SYMBOL)
    private String symbol;

    @Size(max = 255)
    @Column(name = Columns.MARK_PRICE)
    private String markPrice;

    public static final String TABLE = "mark_price";

    private static class Columns{
        private static final String ID = "id";
        private static final String SYMBOL = "symbol";
        private static final String MARK_PRICE = "mark_price";
    }
}
