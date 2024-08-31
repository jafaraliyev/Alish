package com.alish.backend.controller;

import com.alish.backend.dto.TradeDTO;
import com.alish.backend.model.Trade;
import com.alish.backend.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/trades")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @GetMapping("/all")
    public ResponseEntity<List<Trade>> getAllTrades() {
        List<Trade> trades = tradeService.getAllTrades();
        return new ResponseEntity<>(trades, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Trade> createTrade(@RequestBody TradeDTO tradeDTO) {
        Trade createdTrade = tradeService.createTrade(Trade.builder()
                .date(tradeDTO.getDate())
                .tradeItems(tradeDTO.getTradeItems())
                .address(tradeDTO.getAddress())
                .deliveryDate(tradeDTO.getDeliveryDate())
                .totalPrice(tradeDTO.getTotalPrice())
                .build());
        return new ResponseEntity<>(createdTrade, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Trade> getTradeId(@PathVariable long id){
        Trade trade = tradeService.getTradeById(id);
        return new ResponseEntity<>(trade, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Trade> updateTrade(@PathVariable Long id, @RequestBody Trade TradeDetails) {
        Trade updatedTrade = tradeService.updateTrade(id, TradeDetails);
        if (updatedTrade != null) {
            return new ResponseEntity<>(updatedTrade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
