package com.alish.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@Entity
public class TradeItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tIId;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "trade_Id", referencedColumnName = "tId")
    private Trade trade;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "product_Id", referencedColumnName = "pId")
    private Product product;
    private float quantity;
    private float price;
    public static TradeItems defaultTradeItems(){
        return TradeItems.builder().price(1.0f)
                .quantity(1.0f)
                .trade(Trade.defaultTrade())
                .product(Product.defaultProduct())
                .build();
    }
}
