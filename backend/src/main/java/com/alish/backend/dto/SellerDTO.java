package com.alish.backend.dto;

import com.alish.backend.model.Product;
import com.alish.backend.model.Trade;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SellerDTO {
    private long sid;
    private String name;
    private String username;
    private String password;
    private String voen;
    private List<Product> products;
    private List<Trade> tradesHistory;
}
