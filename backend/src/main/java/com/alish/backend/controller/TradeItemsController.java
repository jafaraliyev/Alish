package com.alish.backend.controller;

import com.alish.backend.dto.TradeItemsDTO;
import com.alish.backend.model.TradeItems;
import com.alish.backend.service.TradeItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/tradesItems")
public class TradeItemsController {
    @Autowired
    private TradeItemsService tradeItemService;

    @GetMapping("/all")
    public ResponseEntity<List<TradeItems>> getAllTradeItems() {
        List<TradeItems> tradeItems = tradeItemService.getAllTradeItems();
        return new ResponseEntity<>(tradeItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TradeItems> createTradeItems(@RequestBody TradeItemsDTO tradeItemDTO) {
        TradeItems createdTradeItems = tradeItemService.createTradeItems(TradeItems.builder()
                .price(tradeItemDTO.getPrice())
                .trade(tradeItemDTO.getTrade())
                .product(tradeItemDTO.getProduct())
                .quantity(tradeItemDTO.getQuantity())
                .build());
        return new ResponseEntity<>(createdTradeItems, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TradeItems> getTradeItemsId(@PathVariable long id){
        TradeItems tradeItem = tradeItemService.getTradeItemsById(id);
        return new ResponseEntity<>(tradeItem, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TradeItems> updateTradeItems(@PathVariable Long id, @RequestBody TradeItems TradeItemsDetails) {
        TradeItems updatedTradeItems = tradeItemService.updateTradeItems(id, TradeItemsDetails);
        if (updatedTradeItems != null) {
            return new ResponseEntity<>(updatedTradeItems, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTradeItems(@PathVariable Long id) {
        tradeItemService.deleteTradeItems(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
