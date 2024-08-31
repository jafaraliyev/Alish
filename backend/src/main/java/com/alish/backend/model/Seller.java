package com.alish.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@ToString
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long sid;
    private String name;
    private String username;
    private String password;
    private String voen;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    private List<Product> products;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
    private List<Trade> tradesHistory;
    public static Seller defaultSeller(){
        log.info("Default customer generated.");
        return Seller.builder()
                .name("Example")
                .tradesHistory(null)
                .products(null)
                .password("1234567890")
                .username("example")
                .voen("0").build();
    }
}
