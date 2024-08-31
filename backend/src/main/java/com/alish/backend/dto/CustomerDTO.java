package com.alish.backend.dto;

import com.alish.backend.model.Trade;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDTO {
    long cId;
    private String name, voen, username, password;
    private List<Trade> history;
}
