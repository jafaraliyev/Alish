package com.alish.backend.model;

import java.util.HashMap;
import java.util.List;

import com.alish.backend.repository.ProductRepository;
import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@ToString
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long cId;
    private String name, voen, username, password;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private List<Trade> history;
    public static Customer defaultCustomer(){
        log.info("Default customer generated.");
        return Customer.builder()
                .name("Example")
                .history(null)
                .password("1234567890")
                .username("example")
                .voen("0").build();
    }
}