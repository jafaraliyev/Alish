package com.alish.backend.service;

import com.alish.backend.model.Trade;
import com.alish.backend.repository.TradeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> getAllTrades() {
        log.info("printing all trades");
        return tradeRepository.findAll();
    }

    public Trade getTradeById(Long id) {
        log.info("retrieving a trade by id:" + id);
        return tradeRepository.findById(id).orElse(null);
    }

    public Trade createTrade(Trade trade) {
        log.info("Creating new trade:" + trade.getTId());
        return tradeRepository.save(trade);
    }
    public Trade createDefaultTrade(){
        log.info("creating a default trade");
        return tradeRepository.save(Trade.defaultTrade());
    }
    public Trade updateTrade(Long id, Trade tradeDetails) {
        log.info("updating a trade"+id);
        Trade trade = tradeRepository.findById(id).orElse(null);
        if (trade != null) {
            trade.setDate(tradeDetails.getDate());
            trade.setTradeItems(tradeDetails.getTradeItems());
            trade.setAddress(tradeDetails.getAddress());
            trade.setDeliveryDate(tradeDetails.getDeliveryDate());
            trade.setTotalPrice(tradeDetails.getTotalPrice());
            log.info(id+"trade successfully updated");
            return tradeRepository.save(trade);
        }
        log.error(id+":trade not found");
        return null;
    }

    public void deleteTrade(Long id) {
        log.info("deleting trade by id:"+id);
        tradeRepository.deleteById(id);
    }
}
