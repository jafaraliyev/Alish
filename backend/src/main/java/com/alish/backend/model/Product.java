package com.alish.backend.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
@Entity
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pId;
    @ManyToOne
    @JoinColumn(name = "seller_Id", referencedColumnName = "sId")
    private Seller seller;
    private String name, image, describtion, metric;
    private Integer weight, quantity, number;
    private float price, size;
    public static Product defaultProduct(){
        log.info("Default product is generated.");
        return Product.builder()
                .name("Example")
                .describtion("This is an example product generated by us.")
                .quantity(1)
                .weight(100)
                .metric("kg")
                .number(10).build();
    }
}