package com.alish.backend.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private long id;
    private String name, image, describtion, metric;
    private Integer weight, quantity, number;
    private float price, size;
}
