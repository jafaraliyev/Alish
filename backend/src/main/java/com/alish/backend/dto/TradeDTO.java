package com.alish.backend.dto;


import com.alish.backend.model.Product;
import com.alish.backend.model.TradeItems;
import lombok.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TradeDTO {
    private long tId;
    private List<TradeItems> tradeItems;
    private Date date;
    private long cId, sId;
    private Date deliveryDate;
    private String address;
    private float totalPrice;
}
