package com.alish.backend.dto;

import com.alish.backend.model.Product;
import com.alish.backend.model.Trade;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TradeItemsDTO {
    private long tIId;
    private Trade trade;
    private Product product;
    private float quantity;
    private float price;
}
