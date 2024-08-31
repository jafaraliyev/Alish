package com.alish.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Slf4j
@Entity
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tId;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trade")
    private List<TradeItems> tradeItems;
    private Date date;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "customer_Id", referencedColumnName = "cId")
    private Customer customer;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "seller_Id", referencedColumnName = "sId")
    private Seller seller;
    private Date deliveryDate;
    private String address;
    private float totalPrice;
    public static Trade defaultTrade() {
        log.info("Default Trade is generated.");
        return Trade.builder().customer(null).date(new Date()).tradeItems(null).build();
    }
}